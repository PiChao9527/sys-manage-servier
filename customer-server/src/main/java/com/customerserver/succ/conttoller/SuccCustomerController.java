package com.customerserver.succ.conttoller;

import com.customerserver.succ.commom.Massage;
import com.customerserver.succ.service.SuccCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SuccCustomerController {

    @Autowired
    SuccCustomerService succCustomerService;

    @RequestMapping(value = "/updateCusOrder", method = {RequestMethod.GET})
    public Massage updateCusOrder(int customerId, int countCode){
        Massage massage = new Massage(0,"更新失败！", "");;
        if(succCustomerService.updateCusOrder(customerId, countCode) > 0){
            massage.setStatus(1);
            massage.setMessage("更新成功！");
        }
        return massage;
    }
}
