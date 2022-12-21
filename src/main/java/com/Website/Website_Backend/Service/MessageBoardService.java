package com.Website.Website_Backend.Service;

import com.Website.Website_Backend.Mapper.MessageBoardMapper;
import com.Website.Website_Backend.Model.Data;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class MessageBoardService {
    public List<Data> selectByPage(int page) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageBoardMapper mapper = session.getMapper(MessageBoardMapper.class);
            return mapper.selectByPage(page);
        } catch (Exception e) {
            return null;
        }
    }

    public int selectCount() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageBoardMapper mapper = session.getMapper(MessageBoardMapper.class);
            return mapper.selectCount();
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean insert(String name, String message) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            MessageBoardMapper mapper = session.getMapper(MessageBoardMapper.class);
            mapper.insert(name, message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
