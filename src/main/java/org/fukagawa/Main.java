package org.fukagawa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.fukagawa.dao") // 指定Repository所在包
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}