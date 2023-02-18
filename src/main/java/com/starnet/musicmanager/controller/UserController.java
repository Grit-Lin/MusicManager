package com.starnet.musicmanager.controller;

import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/login")
    public R login(HttpServletRequest request,HttpServletResponse response,String username, String hashedPwd){


        if(this.userService.login(username,DigestUtils.md5DigestAsHex(hashedPwd.getBytes(StandardCharsets.UTF_8)))){
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            return R.success("登录成功");
        }else{
            return R.error("用户名或者密码错误");
        }


    }
}
