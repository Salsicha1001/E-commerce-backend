package com.ecommerceback.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CorsInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "https://cards.marcelogonzaga.dev.br/");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
    }


}
