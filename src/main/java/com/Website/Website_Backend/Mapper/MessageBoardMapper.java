package com.Website.Website_Backend.Mapper;

import com.Website.Website_Backend.Model.Data;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageBoardMapper {
    List<Data> getMessageBoard(@Param("page") int page);
    void setMessageBoard(@Param("name") String name, @Param("message") String message);
    int selectCount();
}
