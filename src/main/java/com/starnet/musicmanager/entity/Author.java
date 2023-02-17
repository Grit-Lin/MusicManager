package com.starnet.musicmanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Author implements Serializable {
    private Long id;
    private Long pictureFileId;
    private String name;
    private String info;
}
