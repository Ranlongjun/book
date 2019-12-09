package com.ranlj.authservice.service;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.service
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 16:52
 * @Description:
 */
public interface UserService {
     String getUser(String userid);
     boolean checkUserIsLogin(String userid);
}
