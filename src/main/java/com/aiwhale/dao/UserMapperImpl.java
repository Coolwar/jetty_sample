package com.aiwhale.dao;

import com.aiwhale.model.User;
import com.aiwhale.tool.DB_Client;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wendong
 * @email wendong@aiwhale.com
 * @date 2017/9/12.
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Override
    public List<User> selectAll() {
        try (SqlSession session = DB_Client.createSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.selectAll();
        }
    }

    @Override
    public User selectById(String id) {
        try (SqlSession session = DB_Client.createSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.selectById(id);
        }
    }

    @Override
    public List<User> selectGteAge(int age) {
        try (SqlSession session = DB_Client.createSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.selectGteAge(age);
        }
    }
}
