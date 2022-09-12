package com.customerserver.succ.service.impl;

import com.customerserver.succ.dao.SuccCustomerMapper;
import com.customerserver.succ.service.SuccCustomerService;

import javax.annotation.Resource;

public class SuccCustomerServiceImpl implements SuccCustomerService {

    @Resource
    SuccCustomerMapper succCustomerMapper;

    @Override
    public int updateCusOrder(int customerId, int countCode) {
        return succCustomerMapper.updateCusOrder(customerId, countCode);
    }
}
