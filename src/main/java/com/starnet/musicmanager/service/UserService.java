package com.starnet.musicmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starnet.musicmanager.entity.User;

public interface UserService extends IService<User> {

    User login(String username, String password);
}
