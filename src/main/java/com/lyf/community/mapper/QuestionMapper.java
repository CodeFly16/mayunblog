package com.lyf.community.mapper;

import com.lyf.community.pojo.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestuibMapper {

    @Insert("insert into (title,description,gmt_create,gmt_modifier,creator,tag) values(#{title}.#{description}.#{gmt_create}.#{gmt_modifier},#{creator},#{tag})")
    void create(Question question);
}
