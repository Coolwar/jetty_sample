package com.aiwhale.tool;

import com.aiwhale.dao.UserMapper;
import com.aiwhale.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DB_Client {

    private static final Logger logger = LogManager.getLogger(DB_Client.class.getName());

    private static SqlSessionFactory sessionFactory = null;

    public static SqlSessionFactory init_pool() {
        String resource = "conf/mybatis-config.xml";
        logger.info("初始化mybatis：" + resource);
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //添加mapper配置
            Configuration configuration = sessionFactory.getConfiguration();
            configuration.addMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("初始化数据库连接池异常", e);
        }
        return sessionFactory;
    }

    public static SqlSession createSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        System.out.println("初始化mybatis....");
        init_pool();
        try (SqlSession session = DB_Client.createSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectAll();
            System.out.println("所有用户：\n" + users);
        }
    }
}
