package com.rdp.template.webfilter;

import com.rdp.template.domain.RequestLog;
import com.rdp.template.service.RequestLogService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.*;

/**
 * 记录访问日志
 * @author Tim
 */
@Component
public class RequestLogFilter extends OncePerRequestFilter {

    @Autowired
    private RequestLogService requestLogService;

    /**
     * 日志队列
     */
    private static ConcurrentLinkedQueue logQueue = new ConcurrentLinkedQueue();
    private ScheduledExecutorService executorService;
    private final static int maxLogItems = 1000;

    public RequestLogFilter() {

        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(() -> {
            if(!logQueue.isEmpty()){
                var list = new ArrayList<RequestLog>(logQueue.size());

                for(var thousand = 0; thousand <= logQueue.size()/maxLogItems; ++thousand){
                    for (var i = 0; i < Math.min(logQueue.size(), 1000); ++i){
                        list.add((RequestLog)logQueue.poll());
                    }
                    requestLogService.batchInsert(list);
                    list.clear();
                }
            }
        }, 1, 10, TimeUnit.SECONDS);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var startTime = System.currentTimeMillis();
        var requestWrapper = new ContentCachingRequestWrapper(request);
        var responseWrapper = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String requestPayload = getPayLoad(requestWrapper.getContentAsByteArray(),
                request.getCharacterEncoding());
        String responsePayload = getPayLoad(responseWrapper.getContentAsByteArray(),
                response.getCharacterEncoding());
        responseWrapper.copyBodyToResponse();

        var timeSpan = System.currentTimeMillis()-startTime;

        //浏览器代理
        var userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));

        var log = new RequestLog();
        log.setSeq(UUID.randomUUID().toString());
        log.setProgramId(0);
        log.setProgramName("");
        log.setMethod(request.getMethod());
        log.setUrl(getFullUrl(request));
        log.setAbsolutePath(request.getRequestURI());
        log.setIp(requestWrapper.getRemoteAddr());
        log.setTimeSpan(timeSpan);
        log.setCreateTime(new Date());
        log.setUserId("");
        log.setUrlRefeerer(request.getHeader("referer") != null? request.getHeader("referer") : "");
        log.setServerIp(request.getServerName());
        log.setBrowserVersion(userAgent.getBrowser().getName() + " " + userAgent.getBrowserVersion());
        log.setPlatform("");
        log.setRequestContent(requestPayload);
        log.setResponseContent(responsePayload);
        logQueue.add(log);



        //requestLogService.insertSelective(log);
    }

    /**
     * 获取PayLoad内容
     * @param buf
     * @param characterEncoding
     * @return
     */
    private String getPayLoad(byte[] buf, String characterEncoding) {
        String payload = "";
        if (buf == null) return payload;
        if (buf.length > 0) {
            int length = Math.min(buf.length, 1024);
            try {
                payload = new String(buf, 0, length, characterEncoding);
            } catch (UnsupportedEncodingException ex) {
                payload = "[unknown]";
            }
        }
        return payload;
    }

    /**
     * 获取完整的URL路径
     * @param request
     * @return
     */
    private String getFullUrl(HttpServletRequest request) {
        return request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort()  + request.getServletPath();
    }

}
