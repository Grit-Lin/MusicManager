package com.starnet.musicmanager.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.common.TokenContext;
import com.starnet.musicmanager.dto.MusicDTO;
import com.starnet.musicmanager.entity.Music;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:
 * @date:
 * @description
 */
@RestController
@RequestMapping("/music")
public class MusicController {

//    @GetMapping("/list")
//    public R<List<MusicDTO>> list() {
//        List<MusicDTO> list = new ArrayList<>();
//        for (long i = 0L; i < 30; i++) {
//            MusicDTO music = new MusicDTO();
//            music.setId(i);
//            music.setName("name" + i);
//            music.setSinger("singer" + i);
//            music.setAlbum("album" + i);
//            list.add(music);
//        }
//        return R.success(list);
//    }

    @GetMapping("/list")
    public R<List<MusicDTO>> list(@RequestBody TokenContext ctx) {
        Long userId = ctx.getUserId();

        LambdaQueryWrapper<Music> lqw = new LambdaQueryWrapper<>();
        lqw.eq(userId != null, Music :: getUserId, userId);



        return R.success(null);
    }
}
