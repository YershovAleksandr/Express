package com.nam.express.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private static Logger log = LoggerFactory.getLogger(DataSource.class);

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/express?useUnicode=true&characterEncoding=utf-8";
    private static String username = "testuser";
    private static String password = "5550635";

    public static Connection getConnection(){
        Connection con = null;

        try{
            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            log.error("DB Error", e);
        }

        return con;
    }
}
