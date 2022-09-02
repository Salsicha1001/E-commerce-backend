package com.ecommerceback.model.Util;

public class ResponseModel {
    private Integer status;
    private String msg;
    private Object obj;
    public static ResponseModel build() {
        return new ResponseModel();
    }
    public static ResponseModel created(String msg) {
        return new ResponseModel(201, msg, null);
    }
    public static ResponseModel created(String msg, Object obj) {
        return new ResponseModel(201, msg, obj);
    }
    public static ResponseModel ok(String msg) {
        return new ResponseModel(200, msg, null);
    }
    public static ResponseModel ok(String msg, Object obj) {
        return new ResponseModel(200, msg, obj);
    }
    public static ResponseModel error(String msg) {
        return new ResponseModel(400, msg, null);
    }
    public static ResponseModel error(String msg, Object obj) {
        return new ResponseModel(500, msg, obj);
    }
    private ResponseModel() {
    }
    private ResponseModel(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }
    public Integer getStatus() {
        return status;
    }
    public ResponseModel setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public String getMsg() {
        return msg;
    }
    public ResponseModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public Object getObj() {
        return obj;
    }
    public ResponseModel setObj(Object obj) {
        this.obj = obj;
        return this;
    }
}
