package br.com.multitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MultitenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultitenantApplication.class, args);
    }

}
