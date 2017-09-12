package com.aiwhale.dao;

import com.aiwhale.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wendong
 * @email wendong@aiwhale.com
 * @date 2017/9/12.
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where id=#{0}")
    User selectById(String id);

    @Select("<script>" +
            "select * from user " +
            "<if test='age !=0'>" +
            "   where >= #{age}" +
            "</if>" +
            "</script>")
    List<User> selectGteAge(@Param("age") int age);

}
