package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.entity.Music;
import com.starnet.musicmanager.mapper.MusicMapper;
import com.starnet.musicmanager.service.MusicService;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements MusicService {
}
