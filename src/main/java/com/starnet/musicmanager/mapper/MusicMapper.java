package com.starnet.musicmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starnet.musicmanager.entity.Music;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MusicMapper extends BaseMapper<Music> {
}
