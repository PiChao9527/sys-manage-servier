package com.userservice.succ.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Data
@Table("succ_user")
@ToString
public class SuccUser {

    private int userId;
    private String userName;
    private String userDepartment;
    private String userRole;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String userSex;
    private String userBirthday;
    private String userStatus;
    private LocalDateTime userCreatedDate;
    private LocalDateTime userUpdatedDate;

    public SuccUser(int userId, String userName, String userDepartment, String userRole, String userPassword, String userEmail, String userPhone, String userAddress, String userSex, String userBirthday, String userStatus, LocalDateTime userCreatedDate, LocalDateTime userUpdatedDate) {
        this.userId = userId;
        this.userName = userName;
        this.userDepartment = userDepartment;
        this.userRole = userRole;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userStatus = userStatus;
        this.userCreatedDate = userCreatedDate;
        this.userUpdatedDate = userUpdatedDate;
    }

    public SuccUser() {
    }
}

