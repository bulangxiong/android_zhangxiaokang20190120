package com.bwei.android_zhangxiaokang20190120.bean;

/**
 * Created by zxk
 * on 2019/1/20 17:49
 * QQ:666666
 * Describe:
 */
public class GoodsBean<T> {



    private String msg;
    private T seller;
    private String code;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getSeller() {
        return seller;
    }

    public void setSeller(T seller) {
        this.seller = seller;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
