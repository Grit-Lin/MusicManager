package com.starnet.musicmanager.dto;

import com.starnet.musicmanager.entity.Music;
import lombok.Data;

import java.io.Serializable;

@Data
public class MusicDTO extends Music {
    private Long id;
    private String name;
    private String singer;
    private String album;
}
