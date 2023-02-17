package com.starnet.musicmanager.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String hashedPassword;
}
