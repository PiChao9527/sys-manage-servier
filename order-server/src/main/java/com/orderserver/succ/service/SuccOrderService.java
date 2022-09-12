package com.orderserver.succ.service;


import com.orderserver.succ.commom.PageUtil;
import com.orderserver.succ.entity.SuccOrder;

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
