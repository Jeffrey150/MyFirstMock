package com.afei.jktest;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

public class Result {
    private String code;
    private String msg;
    private String getDataWay;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String,Object> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getGetDataWay() {
        return getDataWay;
    }

    public void setGetDataWay(String getDataWay) {
        this.getDataWay = getDataWay;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
