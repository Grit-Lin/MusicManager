package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.entity.Music;
import com.starnet.musicmanager.mapper.MusicMapper;
import com.starnet.musicmanager.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

//    public IPage<Music> getPage (int page, int pageSize) {
//        IPage<Music> getPage = new Page<>(page, pageSize);
//        LambdaQueryWrapper<Music> lqw = new LambdaQueryWrapper<>();
//        lqw.orderByAsc(Music :: getId);
//        getPage = musicMapper.selectPage(getPage, lqw);
//        return getPage;
//    }

    /**
     * 根据userId筛选出用户账户下的所有音乐。
     * @param userId
     * @return
     */
    public List<Music> list(int userId) {
        LambdaQueryWrapper<Music> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Music :: getUserId, userId)
                .orderByAsc(Music :: getId);
        return musicMapper.selectList(lqw);
    }
}
