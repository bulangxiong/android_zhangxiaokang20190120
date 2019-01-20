package com.bwei.android_zhangxiaokang20190120.bean;

/**
 * Created by zxk
 * on 2019/1/20 14:12
 * QQ:666666
 * Describe:
 */
public class Result<T> {
    String msg;
    String code;
    T data;
    int  page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
