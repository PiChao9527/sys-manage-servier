package com.orderserver.succ.conttoller;

import com.alibaba.fastjson.JSON;
import com.orderserver.succ.commom.Massage;
import com.orderserver.succ.commom.PageResult;
import com.orderserver.succ.commom.PageUtil;
import com.orderserver.succ.entity.SuccOrder;
import com.orderserver.succ.service.SuccOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PiChao
 * 订单控制类
 */
@RestController
@RequestMapping("order")
public class SuccOrderController {

    @Resource
    private SuccOrderService succOrderService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getListPage", method = {RequestMethod.POST})
    public PageResult getOrderListPage(int pageNum, int pageSize) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("pageNum", (pageNum - 1) * pageSize);
            map.put("pageSize", pageSize);
            PageUtil pageUtil = new PageUtil(map);
            PageResult pageResult = null;
            if(succOrderService.getOrderListPage(pageUtil) != null) {
                pageResult = new PageResult(succOrderService.getOrderListPage(pageUtil),
                        succOrderService.getOrderListPage(pageUtil).size(), pageSize, pageNum);
            }
            return pageResult;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/getOrderById", method = {RequestMethod.POST})
    public SuccOrder getOrderById(int orderId) {
        return succOrderService.selectOrderById(orderId);
    }

    @RequestMapping(value = "/addOrder" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Massage addUser(@RequestBody String succOrderString) {
        SuccOrder succOrder = JSON.parseObject(succOrderString,SuccOrder.class);
        succOrder.setOrderProgress(0);
        succOrder.setOrderStatus(0);
        succOrder.setOrderMakedate(LocalDateTime.now().withNano(0));
        succOrder.setOrderUpdatedate(LocalDateTime.now().withNano(0));
        Massage massage = new Massage(0,"添加失败！", "");
        if(succOrderService.addOrder(succOrder) > 0) {
            massage.setStatus(1);
            massage.setMessage("添加成功！");
            massage.setCount(succOrderService.addOrder(succOrder) + "");
            /**
             * 添加订单成功后，自动维护客户表的客户订单数量
             */
            int code = -1;
            restTemplate.getForObject("http://customer-server/updateCusOrder/"+succOrder.getOrderCustomer()+"/"+code, boolean.class);
            // TODO: 2022/5/11
        }
        return massage;
    }

    @RequestMapping("/deleteOrder")
    public Massage deleteOrder(int orderId) {
        SuccOrder succOrder = succOrderService.selectOrderById(orderId);
        Massage massage = new Massage(0,"删除失败！", "");
        if(succOrderService.deleteOrder(orderId) == 1) {
            massage.setStatus(1);
            massage.setMessage("已删除订单：" + succOrder.getOrderName());

        }
        return massage;
    }

}
