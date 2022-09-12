package com.customerserver.succ.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SuccCustomerMapper {

    int updateCusOrder(int customerId, int countCode);
}
