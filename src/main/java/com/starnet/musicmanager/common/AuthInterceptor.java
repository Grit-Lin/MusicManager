package com.starnet.musicmanager.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
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
                             Object object) throws Exception{


        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)  object;
        Method method=handlerMethod.getMethod();
        if(method.isAnnotationPresent(VerifyToken.class)){
            VerifyToken userLoginToken=method.getAnnotation(VerifyToken.class);
            if(userLoginToken.required()){
                Cookie[] cookies = request.getCookies();
                String token=null;
                for(Cookie c:cookies){
                    if(c.getName().equals("token")){
                        token=c.getValue();
                        break;
                    }
                }

                if(token==null){
                    throw new RuntimeException("没有token");
                }
                String userId;
                try{
                    userId= JWT.decode(token).getAudience().get(0);

                }catch (JWTDecodeException e){
                    throw new RuntimeException("token非法");
                }
                System.out.println(userService);
                User user=userService.getById(userId);

                JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(user.getHashedPwd())).build();
                try{
                    jwtVerifier.verify(token);
                }catch(JWTVerificationException e){
                    throw new RuntimeException("token异常");
                }
                return true;
            }
        }
        return true;
    }

}
