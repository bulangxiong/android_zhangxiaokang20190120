package com.bwei.android_zhangxiaokang20190120.presenter;

import com.bwei.android_zhangxiaokang20190120.core.DataCall;
import com.bwei.android_zhangxiaokang20190120.core.IRequest;
import com.bwei.android_zhangxiaokang20190120.http.HttpUtils;

import java.util.Observable;

/**
 * Created by zxk
 * on 2019/1/20 14:28
 * QQ:666666
 * Describe:
 */
public class CarPresenter extends BasePresenter {

    public CarPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IRequest iRequest = HttpUtils.getHttpUtils().create(IRequest.class);
//        return iRequest.searchProducts((String)args[0],(int)args[1]);
        return null;
    }

}
