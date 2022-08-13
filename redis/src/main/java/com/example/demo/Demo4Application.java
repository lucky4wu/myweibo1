package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class Demo4Application implements CommandLineRunner {

    // inject the actual template
    private final RedisTemplate<String, String> template;

    public Demo4Application(RedisTemplate<String, String> template) {
        this.template = template;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        template.opsForValue().set("hello", "world1");
        System.out.println(template.opsForValue().get("hello"));
    }
}
