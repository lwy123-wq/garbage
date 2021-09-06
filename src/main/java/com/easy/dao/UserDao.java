package com.easy.dao;

import com.easy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user (name,password) VALUES (?,?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }
}
