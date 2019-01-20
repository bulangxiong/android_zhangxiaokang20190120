package com.bwei.android_zhangxiaokang20190120.presenter;

import com.bwei.android_zhangxiaokang20190120.bean.CarBean;
import com.bwei.android_zhangxiaokang20190120.bean.Result;
import com.bwei.android_zhangxiaokang20190120.core.DataCall;

import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zxk
 * on 2019/1/20 14:17
 * QQ:666666
 * Describe:请求接口类
 */
public abstract class BasePresenter {

    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public void unbind() {
        dataCall = null;
    }

    protected abstract Observable observable(Object... args);

    public void request(Object... args) {
//        observable(args)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Result>() {
//
//
//                    @Override
//                    public void accept(Result result) throws Exception {
//                    }
//                });
    }

}
