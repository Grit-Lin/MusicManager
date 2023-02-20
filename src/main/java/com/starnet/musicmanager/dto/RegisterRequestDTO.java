package com.starnet.musicmanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequestDTO implements Serializable {
    private String username;
    private String password;
}
