package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.entity.Author;
import com.starnet.musicmanager.mapper.AuthorMapper;
import com.starnet.musicmanager.service.AuthorService;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author> implements AuthorService {
}
