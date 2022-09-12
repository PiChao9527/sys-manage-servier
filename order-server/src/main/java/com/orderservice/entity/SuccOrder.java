package com.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("succ_order")
@AllArgsConstructor
@NoArgsConstructor
public class SuccOrder {

    private int orderId;
    private int orderUserId;
    private String orderName;
    private String orderPrice;
    private int orderCustomer;
    private int orderProgress;
    private int orderStatus;
    private String orderDescribe;
    private LocalDateTime orderMakedate;
    private LocalDateTime orderUpdatedate;

}
