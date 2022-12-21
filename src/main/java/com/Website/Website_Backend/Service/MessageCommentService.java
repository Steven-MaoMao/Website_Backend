package com.Website.Website_Backend.Service;

import com.Website.Website_Backend.Mapper.MessageCommentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class MessageCommentService {
    public boolean insert(String name, String comment, int parent) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageCommentMapper mapper = session.getMapper(MessageCommentMapper.class);
            mapper.insert(name, comment, parent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
