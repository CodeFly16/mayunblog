package com.lyf.community.mapper;

import com.lyf.community.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("Insert into user(ACCOUNT_ID,NAME,TOKEN,GMT_CREATE,GMT_MODIFIER) values (#{accountId},#{name},#{token},#{gmtCreate},#{gtmModified})")
    void insert(User user);
}
