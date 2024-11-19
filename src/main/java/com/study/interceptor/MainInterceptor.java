package com.study.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.HandlerInterceptor;

public class MainInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication!= null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            // 检查 principal 是否是 User 类型
            if (principal instanceof User user) {
                request.setAttribute("nickname", user.getUsername());
            }
        }
        return true;
    }
}
