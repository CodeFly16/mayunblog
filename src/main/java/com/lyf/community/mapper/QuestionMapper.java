package com.lyf.community.mapper;

import com.lyf.community.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modifier,creator,tag,avatar_url) values (#{title},#{description},#{gmtCreate},#{gmtModifier},#{creator},#{tag},#{avatarUrl})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select * from question where creator = #{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param("size") Integer size);

    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    @Select("select * from question where id = #{id}")
    Question getById(@Param("id") Integer id);

    @Update("update question set title = #{title},description = #{description},gmt_modifier=#{gmtModifier},tag = #{tag} where id = #{id}")
    void update(Question question);
}
