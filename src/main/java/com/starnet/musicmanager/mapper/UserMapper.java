package com.starnet.musicmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starnet.musicmanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
