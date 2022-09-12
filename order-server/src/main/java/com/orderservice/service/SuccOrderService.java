package com.orderservice.service;

import com.orderservice.common.PageUtil;
import com.orderservice.entity.SuccOrder;

import java.util.List;

public interface SuccOrderService {

    List<SuccOrder> getOrderListPage(PageUtil pageUtil);

    SuccOrder selectOrderById(int orderId);

    int updateOrder(SuccOrder order, int orderId);

    int deleteOrder(int orderId);

    int addOrder(SuccOrder order);

    List<SuccOrder> selectOrderByOrderPro(int orderPro);

    List<SuccOrder> selectOrderByUser(int userId, String userPhone);
}
