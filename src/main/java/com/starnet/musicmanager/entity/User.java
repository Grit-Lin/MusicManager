package com.starnet.musicmanager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("t_user")
@Data
public class User implements Serializable {
    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String hashedPwd;
}
