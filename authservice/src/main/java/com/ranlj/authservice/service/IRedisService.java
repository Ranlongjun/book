package com.ranlj.authservice.service;

import java.util.Set;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.service
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 15:59
 * @Description:
 */
public interface IRedisService {
    /**
     * redis添加数据
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value);
    /**
     * redis获取数据
     * @param key
     * @param value
     * @return
     */
    public String get(String key);
    /**
     * 设置当前数据key的有效时间单位为秒
     * @param key
     * @param expire
     * @return
     */
    public boolean expire(String key,long expire);
    /**
     *
     * @Title: getExpire
     * @Description: 获取key的生命周期时间
     * @param @param key
     * @param @return    参数
     * @return Long    返回类型
     * @throws
     */
    public Long getExpire(String key);
    /**
     * redis 添加数据
     * @param key
     * @param obj
     * @return
     */
    public <T> boolean setObj(String key ,Object obj);
    /**
     * redis 获取数据
     * @param key
     * @param clz
     * @return
     */
    public <T> Object getObj(String key,Class<T> clz);
    /**
     * 判断当前redis中的数据是否存在
     * @param key
     * @return
     */
    public boolean exist(String key);
    /**
     * 删除redis中的数据
     * @param key
     */
    public void remove(String... key);
    /**
     *
     * @Title: getKeys
     * @Description: 模糊匹配key
     * @param pattern
     * @return
     * @date 2019年11月12日
     */
    public Set<String> getKeys(String pattern);
}
