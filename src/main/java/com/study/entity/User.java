package com.study.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
}
