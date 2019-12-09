package com.ranlj.authservice.pojo;

import java.io.Serializable;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.POJO
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 15:40
 * @Description: 认证返回结果消息对象
 */
public class ResultMessage implements Serializable {
    ;
    //返回编码
    private String code;
    //状态 true,false
    private boolean status;
    //状态说明
    private String message;
    //返回结果对象
    private Object result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ResultMessage(String code, boolean status, String message, Object result) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ResultMessage(boolean status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
