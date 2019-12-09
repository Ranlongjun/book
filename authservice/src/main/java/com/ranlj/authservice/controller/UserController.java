package com.ranlj.authservice.controller;

import com.ranlj.authservice.config.Message;
import com.ranlj.authservice.pojo.ResultMessage;
import com.ranlj.authservice.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.controller
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 16:54
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(UserController.class);

    /**
     * 
     * @param userid
     * @return
     */
    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam String userid){
        return userService.getUser(userid);
    }

    /**
     * 检测是否登录
     * @param userid
     * @return
     */
    @RequestMapping("/checkIsLogin")
    public ResultMessage checkIsLogin(@RequestParam String userid){
        ResultMessage resultMessage = null;
        try {
            logger.info("账号已登录"+userid);
           resultMessage = new ResultMessage(true,"认证成功",userService.checkUserIsLogin(userid));
        }catch (Exception e){
            logger.info("失败"+e.getMessage());
            resultMessage = new ResultMessage(false,"认证失败",e.getMessage());
        }
        return resultMessage;
    }
}
