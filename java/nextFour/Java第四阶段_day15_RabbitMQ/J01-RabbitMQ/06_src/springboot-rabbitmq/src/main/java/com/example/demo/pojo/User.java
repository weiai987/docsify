package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实例
 * @author :master
 * @date :202006011
 */

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String userName;

    private Integer userAge;

    private String userResume;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", userResume='" + userResume + '\'' +
                '}';
    }
}