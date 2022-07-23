package com.userservice.succ.conttoller;

import com.alibaba.fastjson.JSON;
import com.userservice.succ.common.Massage;
import com.userservice.succ.entity.SuccUser;
import com.userservice.succ.service.SuccUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * create by wangpc may.6
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private SuccUserService succUserService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/addUser" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Massage addUser(@RequestBody String jsonStringUser){
        SuccUser newUser = JSON.parseObject(jsonStringUser,SuccUser.class);
        if(succUserService.selectUserByPhone(newUser.getUserPhone()) != null){
            return new Massage(0,"该手机号已被注册！","");
        }else{
            newUser.setUserPassword(bCryptPasswordEncoder.encode(newUser.getUserPassword()));
            return succUserService.addUser(newUser);
        }
    }

    @RequestMapping(value = "/selectUserById" , method = RequestMethod.POST)
    public Massage selectUserById(@RequestParam("userId") int userId){
        Massage massage = new Massage(0,"查无此人","");
        SuccUser succUser = succUserService.selectUserById(userId);
        if(succUser != null){
            logger.debug(":selectUserById:" + JSON.toJSONString(succUser));
            massage.setStatus(1);
            massage.setMessage("查询成功");
            massage.setCount(succUser.toString());
        }
        return JSON.parseObject(JSON.toJSONString(massage),Massage.class);
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public Massage login(@RequestParam("userPhone") String userPhone,@RequestParam("userPassword") String userPassword){
        Massage massage = new Massage(0,"登录失败！","");
        try {
            if(userPhone == null || userPassword == null || userPhone.isEmpty() || userPassword.isEmpty()){
                massage.setMessage("手机号或密码不能为空！");
            }
            String dbUser = succUserService.login(userPhone,userPassword);
            if(dbUser != null && !dbUser.isEmpty()){
                massage.setStatus(1);
                massage.setMessage("登录成功!");
                logger.info(JSON.toJSONString(dbUser));
            }else {
                massage.setMessage("手机号或密码错误！");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return massage;
        }
    }
}
