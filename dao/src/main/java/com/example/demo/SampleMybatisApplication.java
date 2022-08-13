package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SampleMybatisApplication implements CommandLineRunner {

    private final CityMapper cityMapper;
    private final CityDao cityDao;

    public SampleMybatisApplication(CityMapper cityMapper, CityDao cityDao) {
        this.cityMapper = cityMapper;
        this.cityDao = cityDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityMapper.findByState("CA"));
        System.out.println(this.cityDao.selectCityById(2));
    }

}