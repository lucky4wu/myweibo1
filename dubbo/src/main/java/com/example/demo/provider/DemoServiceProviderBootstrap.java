package com.example.demo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@EnableDubbo(scanBasePackages = "com.example.demo.service")
@PropertySource(value = "classpath:/provider-config.properties")
@SpringBootApplication
public class DemoServiceProviderBootstrap {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoServiceProviderBootstrap.class, args);
        System.out.println("DemoServiceProviderBootstrap provider is starting...");
        System.in.read();
    }

}
