package com.bwei.android_zhangxiaokang20190120.core;

import com.bwei.android_zhangxiaokang20190120.bean.Result;

/**
 * Created by zxk
 * on 2019/1/20 14:17
 * QQ:666666
 * Describe:成功或失败的接口
 */
public interface DataCall {
    //成功
    void loadSuccess(Result result);
    //失败
    void loadError(Throwable throwable);
}
