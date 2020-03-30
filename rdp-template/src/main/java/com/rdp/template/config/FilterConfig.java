package com.rdp.template.config;


import com.rdp.template.webfilter.RequestLogFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.*;

/**
 * @author 10011531
 */
@Configuration
public class FilterConfig {

    @Autowired
    private RequestLogFilter requestLogFilter;

    @Bean
    public FilterRegistrationBean registerFilter() {
        var registration = new FilterRegistrationBean();

        registration.setFilter(requestLogFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("exclusions","/actuator/*,/shutdown");
        registration.setName("RequestLogFilter");
        registration.setOrder(1);
        return registration;
    }
}