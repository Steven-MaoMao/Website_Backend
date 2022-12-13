package com.Website.Website_Backend.Model;

import lombok.Data;

// 数据库表Message_Comment
@Data
public class MessageComment {
    // id
    private int id;

    // 昵称
    private String name;

    // 评论
    private String comment;

    // 时间
    private String time;

    // 留言id
    private int parent;

    // 是否管理员
    private boolean manager;
}
