package com.ibm.academy.cms.filmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class FilmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmServiceApplication.class, args);
    }

}
