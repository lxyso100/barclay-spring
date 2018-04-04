package com.barclay.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author YIYAO
 * @Date 2018/3/27 10:42
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class Result {
    private String code;
    private String msg;
    private List<Object> data = new ArrayList<>();

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

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public void addAll(List<Object> data) {
        this.data.add(data);
    }

    public void add(Object data){
        this.data.add(data);
    }

    public static Result createSuccess(Object data){
        Result result = createSuccess();
        result.add(data);
        return result;
    }

    public static Result createSuccess(){
        Result result =  new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    public static Result createFailed(String msg){
        Result result = createFailed();
        result.setMsg(msg);
        return result;
    }

    public static Result createFailed(){
        Result result =  new Result();
        result.setCode(ResultEnum.FAILED.getCode());
        result.setMsg(ResultEnum.FAILED.getMsg());
        return result;
    }
}
