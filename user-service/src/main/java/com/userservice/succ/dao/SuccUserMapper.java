package com.userservice.succ.dao;

import com.userservice.succ.entity.SuccUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SuccUserMapper {

    int addUser(SuccUser user);

    SuccUser selectUserById(int userId);

    SuccUser selectUserByPhone(String userPhone);

    String login(@Param("userPhone") String userPhone, String userPassword);

    SuccUser selUserByUsername(String username);
}
