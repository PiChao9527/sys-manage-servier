package com.userservice.succ.service.impl;

import com.userservice.succ.common.Massage;
import com.userservice.succ.dao.SuccUserMapper;
import com.userservice.succ.entity.SuccUser;
import com.userservice.succ.service.SuccUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SuccUserImpl implements SuccUserService {

    @Resource
    private SuccUserMapper succUserMapper;

    @Override
    public Massage addUser(SuccUser user) {
        try {
            succUserMapper.addUser(user);
        }catch (Exception ex){
            ex.printStackTrace();
            return new Massage(0,"添加失败","");
        }

        return new Massage(1, "添加成功","");
    }

    @Override
    public SuccUser selectUserById(int userId) {
        return  succUserMapper.selectUserById(userId);
    }

    @Override
    public SuccUser selectUserByPhone(String userPhone) {
        return succUserMapper.selectUserByPhone(userPhone);
    }

    @Override
    public String login(String userPhone, String userPassword) {

        return succUserMapper.login(userPhone,userPassword);
    }

    @Override
    public SuccUser selUserByUsername(String userName) {
        return succUserMapper.selUserByUsername(userName);
    }


}
