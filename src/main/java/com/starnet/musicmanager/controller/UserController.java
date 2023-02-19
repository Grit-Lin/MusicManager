package com.starnet.musicmanager.controller;

import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.common.TokenUtil;
import com.starnet.musicmanager.common.VerifyToken;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.service.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/login")
    public R<String> login(String username, String password) {
        User user = this.userService.login(username, password);
        return R.success(TokenUtil.getToken(user.getId()));
    }

    @PostMapping("/user")
    public R<RegisterResp> register(@RequestBody RegisterReq req) {
        User user = this.userService.register(req.getUsername(), req.getPassword());
        String token = TokenUtil.getToken(user.getId());
        return R.success(new RegisterResp(user, token));
    }
}

@Data
class RegisterReq implements Serializable {
    private String username;
    private String password;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RegisterResp implements Serializable {
    private User user;
    private String token;
}
