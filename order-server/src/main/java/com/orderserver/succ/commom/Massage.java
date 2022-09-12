package com.orderserver.succ.commom;

public class Massage {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String FAIL = "fail";
    public static final String WARNING = "warning";

    private int status;
    private String message;
    private String count;

    public Massage(int status, String message, String count) {
        this.status = status;
        this.count = count;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
