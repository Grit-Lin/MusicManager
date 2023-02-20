package com.starnet.musicmanager.controller;

import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.common.TokenUtil;
import com.starnet.musicmanager.dto.RegisterRequestDTO;
import com.starnet.musicmanager.dto.RegisterResponseDTO;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.service.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public R<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO req) {
        User user = this.userService.register(req.getUsername(), req.getPassword());
        String token = TokenUtil.getToken(user.getId());
        return R.success(new RegisterResponseDTO(user, token));
    }
}
