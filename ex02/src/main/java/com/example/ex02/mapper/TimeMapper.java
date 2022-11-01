package com.example.ex02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TimeMapper {
    public String getTime();

    // 해당 메소드 위에 태그로 적어주면 바로 사용 가능하다.
    @Select("SELECT SYSDATE FROM DUAL")
    public String getTimeQuick();
}
