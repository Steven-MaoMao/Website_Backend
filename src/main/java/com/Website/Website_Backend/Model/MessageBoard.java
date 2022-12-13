package com.Website.Website_Backend.Model;

import lombok.Data;

// 数据库表Message_Board
@Data
public class MessageBoard {
    // id
    private int id;

    // 昵称
    private String name;

    // 留言
    private String message;

    // 时间
    private String time;

    // 是否管理员
    private boolean manager;
}
