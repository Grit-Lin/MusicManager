package com.starnet.musicmanager.controller;

import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.common.TokenUtil;
import com.starnet.musicmanager.common.VerifyToken;
import com.starnet.musicmanager.service.UserService;
import com.starnet.musicmanager.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    private static class LoginReq implements Serializable {
        private String username;
        private String password;
    }
    @GetMapping("/login")
    public R<?> login(String username, String hashedPwd) {
        Boolean res = this.userService.login(username, DigestUtils.md5DigestAsHex(hashedPwd.getBytes(StandardCharsets.UTF_8)));
        if (res != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            Cookie cookie = new Cookie("token", TokenUtil.getToken(res.toString(), DigestUtils.md5DigestAsHex(hashedPwd.getBytes(StandardCharsets.UTF_8))));
            response.addCookie(cookie);
            return R.success("成功");
        } else {
            return R.error("用户名或者密码错误");
        }
    }

    @VerifyToken
    @GetMapping("/logout")
    public R<?> logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("token", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        request.getSession().invalidate();
        return R.success("退出成功");
    }
}
