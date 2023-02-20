package com.starnet.musicmanager.controller;

import com.starnet.musicmanager.common.R;
import com.starnet.musicmanager.dto.MusicDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/list")
    public R<List<MusicDTO>> list() {
//        LambdaQueryWrapper<Music> lqw = new LambdaQueryWrapper<>();
//        lqw.orderByAsc(Music :: getId);
//        List<Music> list = musicService.list(lqw);
        List<MusicDTO> list = new ArrayList<>();
        for (long i = 0L; i < 30; i++) {
            MusicDTO music = new MusicDTO();
            music.setId(i);
            music.setName("name" + i);
            music.setSinger("singer" + i);
            music.setAlbum("album" + i);
            list.add(music);
        }
        return R.success(list);
    }

}
