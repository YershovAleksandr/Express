package com.nam.express;

import com.nam.express.util.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        Database.init();

        SpringApplication.run(Main.class, args);
    }
}