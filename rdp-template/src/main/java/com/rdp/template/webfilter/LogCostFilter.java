package com.rdp.template.webfilter;

import java.util.Date;

import com.rdp.template.domain.RequestLog;
import com.rdp.template.service.RequestLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;


/**
 * @author 10011531
 */
@Slf4j
public class LogCostFilter implements Filter {

    @Autowired
    private RequestLogService requestLogService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("----------LogCostFilter/init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);

        //获取执行时间
        var timeSpan = System.currentTimeMillis()-start;

        System.out.println("Execute cost=" + timeSpan);

        var request = (RequestFacade)servletRequest;

        if (request.getServletPath().contains(".")) {
            return;
        }

        //获取全路径
        var url = request.getScheme() +"://" + request.getServerName() + ":" +request.getServerPort()  + request.getServletPath();

        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }

/*
        ResponseFacade resp = (ResponseFacade)servletResponse;

        ServletInputStream is = request.getInputStream();
        byte[] data = new byte[request.getContentLength()];
        is.read(data);
        is.reset();

        ServletInputStream id1 = servletRequest.getInputStream();
        id1.

        ServletOutputStream os = resp.getOutputStream();
        byte[] data1 = new byte[resp.getBufferSize()];
        is.read(data1);
*/

        var log = new RequestLog();
        log.setSeq(UUID.randomUUID().toString());
        log.setProgramId(0);
        log.setProgramName("");
        log.setMethod(request.getMethod());
        log.setUrl(url);
        log.setAbsolutePath(request.getRequestURI());
        log.setIp(servletRequest.getRemoteAddr());
        log.setTimeSpan(timeSpan);
        log.setCreateTime(new Date());
        log.setUserId("");
        log.setUrlRefeerer(request.getHeader("referer") != null? request.getHeader("referer") : "");
        log.setServerIp(request.getServerName());
        log.setBrowserVersion(getBrowserName(request.getHeader("user-agent")));
        log.setPlatform("");
        log.setRequestContent("");
        log.setResponseContent("");
        requestLogService.insertSelective(log);
    }

    @Override
    public void destroy() {
        log.info("----------LogCostFilter/destroy");
    }


    public String getBrowserName(String agent) {
        if(agent.indexOf("msie 7")>0){
            return "ie7";
        }else if(agent.indexOf("msie 8")>0){
            return "ie8";
        }else if(agent.indexOf("msie 9")>0){
            return "ie9";
        }else if(agent.indexOf("msie 10")>0){
            return "ie10";
        }else if(agent.indexOf("msie")>0){
            return "ie";
        }else if(agent.indexOf("opera")>0){
            return "opera";
        }else if(agent.indexOf("opera")>0){
            return "opera";
        }else if(agent.indexOf("firefox")>0){
            return "firefox";
        }else if(agent.indexOf("webkit")>0){
            return "webkit";
        }else if(agent.indexOf("gecko")>0 && agent.indexOf("rv:11")>0){
            return "ie11";
        }else{
            return "Others";
        }
    }

}