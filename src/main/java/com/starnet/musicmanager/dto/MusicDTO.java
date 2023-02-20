package com.starnet.musicmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MusicDTO implements Serializable {
    private Long id;
    private String name;
    private String singer;
    private String album;
}
