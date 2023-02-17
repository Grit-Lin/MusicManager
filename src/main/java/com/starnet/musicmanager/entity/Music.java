package com.starnet.musicmanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Music implements Serializable {
    private Long id;
    private Long musicFileId;
    private Long coverFileId;
    private Long authorId;
    private Long organizationId;
    private Long userId;
    private String info;
    private String lyrics;
    private Integer duration;
}
