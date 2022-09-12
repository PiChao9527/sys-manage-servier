package com.orderserver.succ.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("succcustomer")
public class SuccCustomer {

    private Integer customerId;
    private String customerName;
    private Integer customerOrg;
    private Integer customerNature;
    private Integer customerLevel;
    private Integer customerOrders;
    private String contacts;
    private String cellPhone;
    private String landLine;
    private Integer findUser;
    private String remark;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;


}
