package com.starnet.musicmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starnet.musicmanager.entity.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper extends BaseMapper<File> {
}
