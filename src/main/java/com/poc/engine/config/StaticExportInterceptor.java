package com.poc.engine.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StaticExportInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object h, ModelAndView mv) {
        if (mv != null) {
            // Check if wget sent our custom header
            boolean isStatic = "true".equalsIgnoreCase(req.getHeader("X-Static-Export"));
            mv.addObject("isStaticMapping", isStatic);
        }
    }
}
