package com.nam.express.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private static Logger log = LoggerFactory.getLogger(DataSource.class);

    public static Connection getConnection(){
        Connection con = null;

        String url = "jdbc:mysql://localhost:3306/express?useUnicode=true&characterEncoding=utf-8";
        String user = "testuser";
        String pass = "5550635";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
            log.error("DB Error", e);
        }

        return con;
    }
}
