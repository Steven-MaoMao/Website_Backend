package com.Website.Website_Backend.Model;

// 数据库表Message_Board和Message_Comment联合查询的实体类
@lombok.Data
public class Data {
    // Message_Board表中的字段
    private int mId;
    private String mName;
    private String mMessage;
    private String mTime;

    // Message_Comment表中的字段
    private int cId;
    private String cName;
    private String cComment;
    private String cTime;
    private int cParent;
}
