package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.common.AuthUtil;
import com.starnet.musicmanager.common.exception.LoginFailedException;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.mapper.UserMapper;
import com.starnet.musicmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    public User login(String username, String password) throws LoginFailedException {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        User user = this.userMapper.selectOne(wrapper);
        if (user == null) {
            throw new LoginFailedException("user not found");
        }
        if (!AuthUtil.Verify(password, user.getHashedPwd())) {
            throw new LoginFailedException("password incorrect");
        }
        return user;
    }

    public User register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setHashedPwd(AuthUtil.Encrypt(password));
        this.userMapper.insert(user);
        return user;
    }
}
