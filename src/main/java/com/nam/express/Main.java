package com.nam.express;

import com.nam.express.util.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args){
        Database.init();

        SpringApplication.run(Main.class, args);
    }
}