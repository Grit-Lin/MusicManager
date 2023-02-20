package com.starnet.musicmanager.dto;

import com.starnet.musicmanager.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponseDTO implements Serializable {
    private User user;
    private String token;
}
