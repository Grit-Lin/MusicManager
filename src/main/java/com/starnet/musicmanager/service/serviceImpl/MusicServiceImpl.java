package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.common.TokenContext;
import com.starnet.musicmanager.dto.MusicDTO;
import com.starnet.musicmanager.entity.Music;
import com.starnet.musicmanager.mapper.MusicMapper;
import com.starnet.musicmanager.service.MusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
     * @param ctx
     * @return
     */
    public R<List<MusicDTO>> list(@RequestBody TokenContext ctx) {
        Long userId = ctx.getUserId();

        LambdaQueryWrapper<Music> lqw = new LambdaQueryWrapper<>();
        lqw.eq(userId != null, Music :: getUserId, userId);

        List<Music> musicList = this.list(lqw);
        List<MusicDTO> musicDTOList = null;
        musicDTOList = musicList.stream().map((item) -> {
            MusicDTO musicDTO = new MusicDTO();
            BeanUtils.copyProperties(item, musicDTO);


            return musicDTO;
        }).collect(Collectors.toList());

        return R.success(musicDTOList);
    }
}
