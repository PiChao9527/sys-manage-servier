package com.orderserver.succ.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("succattendance")
public class SuccAttendance {

    private Integer userId;
    private String userAction;
    private String remark;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

}
