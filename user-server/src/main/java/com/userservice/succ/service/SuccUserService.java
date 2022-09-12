package com.userservice.succ.service;

import com.userservice.succ.common.Massage;
import com.userservice.succ.entity.SuccUser;

public interface SuccUserService {

    Massage addUser(SuccUser user);

    SuccUser selectUserById(int userId);

    SuccUser selectUserByPhone(String userPhone);

    String login(String userPhone, String userPassword);

    SuccUser selUserByUsername(String userName);

    int updateUserOrder(int userId, int orderId, int count);

}
