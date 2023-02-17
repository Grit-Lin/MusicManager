package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.entity.File;
import com.starnet.musicmanager.mapper.FileMapper;
import com.starnet.musicmanager.service.FileService;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
}
