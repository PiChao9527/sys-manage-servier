package com.orderservice.service.impl;

import com.orderservice.common.PageUtil;
import com.orderservice.dao.SuccOrderMapper;
import com.orderservice.entity.SuccOrder;
import com.orderservice.service.SuccOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuccOrderServiceImpl implements SuccOrderService {

    @Resource
    private SuccOrderMapper succOrderMapper;

    @Override
    public List<SuccOrder> getOrderListPage(PageUtil pageUtil) {
        return succOrderMapper.getOrderListPage(pageUtil);
    }

    @Override
    public SuccOrder selectOrderById(int orderId) {
        return succOrderMapper.selectOrderById(orderId);
    }

    @Override
    public int updateOrder(SuccOrder order, int orderId) {
        return 0;
    }

    @Override
    public int deleteOrder(int orderId) {
        return succOrderMapper.deleteOrder(orderId);
    }

    @Override
    public int addOrder(SuccOrder order) {
        return succOrderMapper.addOrder(order);
    }

    @Override
    public List<SuccOrder> selectOrderByOrderPro(int orderPro) {
        return null;
    }

    @Override
    public List<SuccOrder> selectOrderByUser(int userId, String userPhone) {
        return null;
    }
}
