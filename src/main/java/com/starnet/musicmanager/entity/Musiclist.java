package com.starnet.musicmanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Musiclist implements Serializable {
    private Long id;
    private Long ownerId;
    private String name;
    private String info;
}
