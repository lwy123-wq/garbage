package com.easy.dao.mapper;

import com.easy.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

   // @Select(value = "SELECT username,password FROM user WHERE id=#{id}")
//    @Results(value = {
//            @Result(column = "id", property = "id"),
//            @Result(column = "name", property = "uName"),
//            @Result(column = "age", property = "uAge"),
//
//    })
    //User findByUserId(@Param("id") int id);


    @Select(value = "SELECT username FROM user WHERE username=#{username}")
    User findByName(@Param("username") String username);


    @Select(value = "SELECT username,password FROM user WHERE username=#{username} AND password=#{password}")
    User findByNameAndPassword(@Param(value = "username") String username, @Param(value = "password") String password);

    @Insert(value = "INSERT INTO user (username,password) VALUES (#{user.username},#{user.password})")
    int insertUser(@Param(value = "user") User user);

 /*   @Update(value = "UPDATE t_user SET name=#{user.name} WHERE id=#{user.id}")
    int updateUser(@Param(value = "user") User user);*/
}
