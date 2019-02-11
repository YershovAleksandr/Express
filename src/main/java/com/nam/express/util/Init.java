package com.nam.express.util;

import java.io.InputStream;
import java.util.Properties;

public class Init {
    public String driver;
    public String url;
    public String username;
    public String password;

    public Init(){
        try(InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties")) {

            Properties prop = new Properties();
            prop.load(is);

            driver = prop.getProperty("spring.datasource.driver-class-name");
            url = prop.getProperty("spring.datasource.url");
            username = prop.getProperty("spring.datasource.username");
            password = prop.getProperty("spring.datasource.password");

            System.out.println(driver);
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
