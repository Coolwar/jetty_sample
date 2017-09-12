package com.aiwhale.service;

import com.aiwhale.dao.UserMapper;
import com.aiwhale.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wendong
 * @email wendong@aiwhale.com
 * @date 2017/9/12.
 */
@Service
public class HelloService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectBy() {
//        return userMapper.selectAll();
        //测试数据
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("wen");
        user.setAge(25);
        User user1 = new User();
        user1.setName("dong");
        user1.setAge(26);
        list.add(user);
        list.add(user1);
        return list;
    }

}
