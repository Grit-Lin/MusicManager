package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.entity.Musiclist;
import com.starnet.musicmanager.mapper.MusiclistMapper;
import com.starnet.musicmanager.service.MusiclistService;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class MusiclistServiceImpl extends ServiceImpl<MusiclistMapper, Musiclist> implements MusiclistService {
}
