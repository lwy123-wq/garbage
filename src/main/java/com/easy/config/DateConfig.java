package com.easy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.easy.config.info.JdbcInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan("com.easy.dao.mapper")
@EnableTransactionManagement
public class DateConfig {
    @Resource
    private JdbcInfo jdbcInfo;
    @Bean
    public DataSource getDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setDriverClassName(jdbcInfo.getDriver());
        return dataSource;
    }


}
