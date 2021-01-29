package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
public interface urldizhiMapper {
    int delteUrlid(@Param("urlid") String paramString);

    int addUrdizhi(@Param("current") String paramString1, @Param("urlBeizhu") String paramString2, @Param("m3u8") String paramString3, @Param("xiazaiBeizhu") String paramString4, @Param("mp4") String paramString5);
}
