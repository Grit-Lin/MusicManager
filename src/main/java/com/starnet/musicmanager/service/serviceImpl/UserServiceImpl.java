package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.entity.User;
import com.starnet.musicmanager.mapper.UserMapper;
import com.starnet.musicmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
            @Autowired
            UserMapper userMapper;

            public boolean login(String username, String hashedPwd){
                QueryWrapper wrapper=new QueryWrapper();
                wrapper.eq("username",username);
                wrapper.eq("hashed_pwd",hashedPwd);
                User user=this.userMapper.selectOne(wrapper);
                if(user!=null) {
                    return true;
                }else{
                    return false;
                }
            }
}
