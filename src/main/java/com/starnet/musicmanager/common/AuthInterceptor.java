package com.starnet.musicmanager.common;

import com.starnet.musicmanager.common.exception.TokenNotFoundException;
import com.starnet.musicmanager.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    UserServiceImpl userService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) {


        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(VerifyToken.class)) {
//            VerifyToken userLoginToken=method.getAnnotation(VerifyToken.class);
            final String token = request.getHeader(TokenUtil.AUTH_HEADER_KEY);
            if (token == null) {
                throw new TokenNotFoundException("header auth field not found");
            }
            TokenContext ctx = TokenUtil.verify(token);
            request.setAttribute("ctx", ctx);
        }
        return true;
    }
}
