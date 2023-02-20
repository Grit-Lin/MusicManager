package com.starnet.musicmanager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("com.starnet.musicmanager.mapper")
public class MusicManagerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MusicManagerApplication.class, args);

        log.info("Project start！");
    }

}
