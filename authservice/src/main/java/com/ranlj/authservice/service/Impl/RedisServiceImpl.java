package com.ranlj.authservice.service.Impl;

import com.ranlj.authservice.service.IRedisService;
import com.ranlj.authservice.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.service.Impl
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 16:01
 * @Description:
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public boolean set(final String key, final String value) {
        boolean result =false;
        result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    public String get(final String key){
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public <T> boolean setObj(String key, Object obj) {
        String value = JSONUtil.toJson(obj);
        return set(key,value);
    }

    @Override
    public <T> T getObj(String key,Class<T> clz) {
        String json = get(key);
        if(json!=null){
            T obj= JSONUtil.toBean(json, clz);
            return obj;
        }
        return null;
    }

    @Override
    public boolean exist(String key) {
        return redisTemplate.hasKey(key);

    }

    @Override
    public void remove(String... key) {
        if(key!=null&&key.length==0){
            redisTemplate.delete(key[0]);
        }else{
            redisTemplate.delete(Arrays.asList(key));
        }

    }

    @Override
    public Long getExpire(String key) {

        return redisTemplate.getExpire(key);
    }

    @Override
    public Set<String> getKeys(String pattern) {

        return redisTemplate.keys(pattern);
    }

}
