package com.nam.express.util;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JDBCSource {
    private static Init init = new Init();

    public static DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(init.driver);
        dataSource.setUrl(init.url);
        dataSource.setUsername(init.username);
        dataSource.setPassword(init.password);

        return dataSource;
    }
}