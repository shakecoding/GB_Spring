package com.example.ex00.dependency;

import com.example.ex00.qualifier.Resturant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ResturantTest {

    @Autowired
    private Resturant resturant;

    @Autowired
    @Qualifier("outback")
    private Resturant outback;

    @Autowired
    @Qualifier("vips")
    private Resturant vips;

    @Test
    public void resturantTest(){
        log.info(resturant + "");
        log.info(outback + "");
        log.info(vips + "");
    }
}
