package com.Website.Website_Backend.Mapper;

import com.Website.Website_Backend.Model.MessageComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageCommentMapper {
    void setMessageComment(@Param("name") String name, @Param("comment") String comment, @Param("parent") int parent);
}
