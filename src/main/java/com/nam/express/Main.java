package com.nam.express;

import com.nam.express.util.Database;
import com.nam.express.util.JDBCSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        Database.init();

        SpringApplication.run(Main.class, args);

        //JDBCSource s = new JDBCSource();
        //ds.mysqlDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCSource.getDataSource());
        //JdbcTemplate jdbcTemplate = new JdbcTemplate();

        int i = jdbcTemplate.queryForObject("Select count(*) from orderdb", Integer.class);

        System.out.println("I = " + i);
    }
}