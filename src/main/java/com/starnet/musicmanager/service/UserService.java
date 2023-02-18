package com.starnet.musicmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService extends IService<User> {

    public boolean login(String username, String hashedPwd);
}
