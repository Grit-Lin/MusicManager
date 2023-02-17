package com.starnet.musicmanager.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class File implements Serializable {
    private Long id;
    private String hash;
    private String path;
    private Integer quote;
}
