package com.starnet.musicmanager.entity;

import lombok.Data;

@Data
public class Music {
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
