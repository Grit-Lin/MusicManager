package com.starnet.musicmanager.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.entity.Music;
import com.starnet.musicmanager.service.serviceImpl.MusicServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:
 * @date:
 * @description
 */
@RestController
@RequestMapping("/music")
public class MusicController {

    private MusicServiceImpl musicService;

    @GetMapping("/list")
    public R<List<Music>> list() {
        LambdaQueryWrapper<Music> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Music :: getId);
        List<Music> list = musicService.list(lqw);
        return R.success(list);
    }

}
