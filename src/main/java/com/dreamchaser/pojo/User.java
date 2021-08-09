package com.dreamchaser.pojo;

import io.swagger.annotations.ApiModel;

/**
 * user
 * 
 * @author sun
 * @version 1.0.0 2020-06-29
 */
@ApiModel(description = "用户实体类")
public class User implements java.io.Serializable {

    /** 管理员账号 */
    private String name;

    /** 管理员密码 */
    private String password;

    /**
     * 获取管理员账号
     * 
     * @return 管理员账号
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置管理员账号
     * 
     * @param name
     *          管理员账号
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取管理员密码
     * 
     * @return 管理员密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置管理员密码
     * 
     * @param password
     *          管理员密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

}