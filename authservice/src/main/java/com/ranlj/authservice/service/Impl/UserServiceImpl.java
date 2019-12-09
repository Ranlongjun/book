package com.ranlj.authservice.service.Impl;

import com.ranlj.authservice.service.IRedisService;
import com.ranlj.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.service.Impl
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 16:53
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    IRedisService RedisService;

    @Override
    public String getUser(String userid) {
        return RedisService.get(userid);
    }

    @Override
    public boolean checkUserIsLogin(String userid) {
        return getUser(userid).isEmpty();
    }
}
