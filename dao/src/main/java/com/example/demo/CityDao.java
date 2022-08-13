package com.example.demo;

import com.example.demo.pojo.City;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class CityDao {

    private final SqlSession sqlSession;

    public CityDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public City selectCityById(long id) {
        return this.sqlSession.selectOne("selectCityById", id);
    }

}
