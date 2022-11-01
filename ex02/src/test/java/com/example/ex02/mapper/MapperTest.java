package com.example.ex02.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTest {
    @Autowired
    private TimeMapper timeMapper; // 인텔리제이 버그 빨간줄 무시

    @Test
    public void timeMapperTest(){

        // timeMapper : org.apache.ibatis.binding.MapperProxy@4e647f39
        // 프록시 -> 가짜 객체 인터페이스 지정한 적이 없기에 구현체는 존재하지 않는다.
        // 스프링이 프록시를 만들어줘서
        // 원본 객체를 상속받아서 프록시를 만든다. 자식타입, == 으로 비교하면 false 가 뜬다.
        // instanceof 로 비교를 해야한다.
        // 원본을 계속 만들면 속도가 너무 떨어진다.
        // 정확히 필요한 부분만 가지고 있는 것이 프록시, 실제 우너본 객체는 아니다.
        // 필요할 때마다 프록시가 원본에서 필요한 데이터만 가지고 나온다.
        log.info("timeMapper : " + timeMapper);
        log.info("getTime : " + timeMapper.getTime());
        log.info("getTime : " + timeMapper.getTimeQuick());
    }
}
