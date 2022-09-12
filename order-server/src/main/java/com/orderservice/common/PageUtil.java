package com.orderservice.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class PageUtil extends LinkedHashMap<String, Object> {
    //当前页码
    private int pageNum;
    //每页条数
    private int pageSize;

    public PageUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.pageNum = Integer.parseInt(params.get("pageNum").toString());
        this.pageSize = Integer.parseInt(params.get("pageSize").toString());
        this.put("pageNum", (pageNum - 1) * pageSize);
        this.put("pageNum", pageNum);
        this.put("pageSize", pageSize);
    }


    public int getpageNum() {
        return pageNum;
    }

    public void setpageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getpageSize() {
        return pageSize;
    }

    public void setpageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "pageNumUtil{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}

