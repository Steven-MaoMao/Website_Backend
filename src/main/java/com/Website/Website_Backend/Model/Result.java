package com.Website.Website_Backend.Model;

import java.util.List;

// 返回给前端的数据格式
@lombok.Data
public class Result {
    // 查询是否成功
    boolean flag = false;

    // 查询到的数据
    List<Data> data = null;

    // 数据库中的记录条数（分页需要使用）
    int count = -1;
}
