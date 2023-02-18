package com.starnet.musicmanager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.starnet.musicmanager.mapper")
public class MusicManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicManagerApplication.class, args);
        log.info("Project start！");
    }

}
