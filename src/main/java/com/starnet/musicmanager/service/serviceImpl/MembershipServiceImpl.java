package com.starnet.musicmanager.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starnet.musicmanager.entity.Membership;
import com.starnet.musicmanager.mapper.MembershipMapper;
import com.starnet.musicmanager.service.MembershipService;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @date:
 * @description
 */
@Service
public class MembershipServiceImpl extends ServiceImpl<MembershipMapper, Membership> implements MembershipService {
}
