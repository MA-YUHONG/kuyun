package com.example.demo.dao;

import com.example.demo.entity.webs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface websMapper {
    webs select(@Param("mainid") Integer paramInteger, @Param("laiyuan") String paramString);

    int addWeb(@Param("mainid") int paramInt, @Param("laiyuan") String paramString1, @Param("current") String paramString2);
}
