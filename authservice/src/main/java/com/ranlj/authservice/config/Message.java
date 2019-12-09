package com.ranlj.authservice.config;

/**
 * @BelongsProject: Book
 * @BelongsPackage: com.ranlj.authservice.config
 * @Author: ranlongjun
 * @CreateTime: 2019-12-06 15:45
 * @Description:
 */
public enum  Message {
    OK("00","成功"),
    FAIL("11","失败");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    Message(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
