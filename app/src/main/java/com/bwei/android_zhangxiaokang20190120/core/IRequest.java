package com.bwei.android_zhangxiaokang20190120.core;

import com.bwei.android_zhangxiaokang20190120.bean.CarBean;
import com.bwei.android_zhangxiaokang20190120.bean.GoodsBean;
import com.bwei.android_zhangxiaokang20190120.bean.Result;
import com.bwei.android_zhangxiaokang20190120.bean.Shop;
import com.bwei.android_zhangxiaokang20190120.bean.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zxk
 * on 2019/1/20 14:19
 * QQ:666666
 * Describe:
 */
public interface IRequest {
    //搜索
    @GET("product/searchProducts")
    Observable<Result<List<CarBean>>> searchProducts(@Query("keywords") String keywords
            , @Query("page") int page
    );
    @GET("product/getProductDetail")
    Observable<GoodsBean<List<User>>> getProductDetail(@Query("uid")int uid);
}
