package com.study.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private int id;
    private int bid;
    private int sid;
    private String sname;
    private String title;
    private Date time;
}
