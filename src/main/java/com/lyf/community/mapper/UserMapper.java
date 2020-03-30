package com.lyf.community.mapper;

import com.lyf.community.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("Insert into user(ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIER,avatar_url) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModifier}),#{avatarUrl}")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(String accountId);

    @Update("update user set name = #{name}, token = #{token}, GMT_MODIFIER = #{gmtModifier},avatar_url=#{avatarUrl} where id = #{id}")
    void update(User dbUser);
}
