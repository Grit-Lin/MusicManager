package com.starnet.musicmanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Organization implements Serializable {
    private Long id;
    private Long ownerId;
    private String name;
    private Boolean visible;
}
