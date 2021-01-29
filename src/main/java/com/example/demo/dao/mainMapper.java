package com.example.demo.dao;

import com.example.demo.entity.main;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface mainMapper {
    main isExist(@Param("name") String paramString);

    int addMain(@Param("name") String paramString1, @Param("beizhu") String paramString2, @Param("img") String paramString3, @Param("yanyuan") String paramString4, @Param("daoyan") String paramString5, @Param("movietype") String paramString6, @Param("place") String paramString7, @Param("gengxintime") String paramString8, @Param("zhuangtai") String paramString9, @Param("language") String paramString10, @Param("shangyingtime") String paramString11, @Param("juqing") String paramString12, @Param("data") String paramString13, @Param("hot") int paramInt);

    Integer selectId(@Param("name") String paramString);
    Integer updates(@Param("id") int id,@Param("img") String img);

    main selectAll(@Param("id") int id);

    Integer updateImg(@Param("id") int id);

    List<main> selectNow();
}
