package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.common.AuthUtil;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.mapper.UserMapper;
import com.starnet.musicmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Boolean login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
        User user = this.userMapper.selectOne(wrapper);
        if (user == null) return false;
        return AuthUtil.Verify(password, user.getHashedPwd());
    }
}
