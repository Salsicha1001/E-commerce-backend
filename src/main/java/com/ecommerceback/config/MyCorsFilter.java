package com.ecommerceback.config;

import com.ecommerceback.utils.MutableHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyCorsFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyCorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating Custom filter ##########");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);

        LOGGER.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());

        mutableRequest.putHeader("Access-Control-Allow-Origin", "*");
        mutableRequest.putHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        mutableRequest.putHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        mutableRequest.putHeader("Access-Control-Max-Age", "3600");
//        mutableRequest.putHeader("x-custom-header", "custom value");
        chain.doFilter(mutableRequest, response);

        LOGGER.info("Logging Response :{}", response.getContentType());
    }

    @Override
    public void destroy() {

    }
}
