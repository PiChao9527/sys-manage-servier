package com.orderserver.succ.dao;

import com.orderserver.succ.commom.PageUtil;
import com.orderserver.succ.entity.SuccOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuccOrderMapper {

    List<SuccOrder> getOrderListPage(PageUtil pageUtil);

    SuccOrder selectOrderById(int orderId);

    int updateOrder(SuccOrder order, int orderId);

    int deleteOrder(int orderId);

    int addOrder(SuccOrder order);

    List<SuccOrder> selectOrderByOrderPro(int orderPro);

    List<SuccOrder> selectOrderByUser(int userId, String userPhone);
}
