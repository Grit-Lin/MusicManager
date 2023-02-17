package com.starnet.musicmanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Membership implements Serializable {
    private Long id;
    private Long userId;
    private Long organizationId;
    private String role;
}
