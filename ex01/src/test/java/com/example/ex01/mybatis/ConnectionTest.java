package com.example.ex01.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void datasourceTest(){
        // try 소괄호 안에 적어주어 마지막 final 을 생략안해도 되는 문법.
        try(Connection connection = dataSource.getConnection()){
            log.info("datasource connection : " + connection);
        }catch (Exception e){
            log.info(e.getMessage());
        };
    }

}
