package com.Website.Website_Backend;

import com.Website.Website_Backend.Mapper.MessageBoardMapper;
import com.Website.Website_Backend.Mapper.MessageCommentMapper;
import com.Website.Website_Backend.Model.Data;
import com.Website.Website_Backend.Model.MessageComment;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
public class MapperTests {
    @Autowired
    private MessageBoardMapper messageBoardMapper;
    private MessageCommentMapper messageCommentMapper;

    @Test
    public void testGetMessageBoard() throws IOException {
        int page = 1;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageBoardMapper mapper = session.getMapper(MessageBoardMapper.class);
            List<Data> dataList = mapper.getMessageBoard(page);
            System.out.println(dataList);
        }
    }

    @Test
    public  void testSetMessageBoard() throws IOException {
        String name = "test";
        String message = "test2";

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageBoardMapper mapper = session.getMapper(MessageBoardMapper.class);
            mapper.setMessageBoard(name, message);
        }
    }

    @Test
    public  void testSelectCount() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageBoardMapper mapper = session.getMapper(MessageBoardMapper.class);
            int count = mapper.selectCount();
            System.out.println(count);
        }
    }

    @Test
    public void testGetMessageComment() throws IOException {
        String name = "test";
        String comment = "test1";
        int parent = 1;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageCommentMapper mapper = session.getMapper(MessageCommentMapper.class);
            mapper.setMessageComment(name, comment, parent);
        }
    }
}
