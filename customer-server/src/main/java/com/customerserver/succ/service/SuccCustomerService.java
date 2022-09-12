package com.customerserver.succ.service;

public interface SuccCustomerService {

    //更新用户下的订单数量
    int updateCusOrder(int customerId, int countCode);

}
