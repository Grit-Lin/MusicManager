package com.starnet.musicmanager.entity;

import lombok.Data;

@Data
public class Author {
    private Long id;
    private Long pictureFileId;
    private String name;
    private String info;
}
