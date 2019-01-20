package com.bwei.android_zhangxiaokang20190120.app;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.commonsdk.UMConfigure;

/**
 * Created by zxk
 * on 2019/1/20 14:16
 * QQ:666666
 * Describe:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(configuration);
        UMConfigure.init(this,"5a12384aa40fa3551f0001d1"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        Service service = new Service() {

            @Override
            public IBinder onBind(Intent intent) {
                return null;
            }
        };
    }
}
