package com.bwei.android_zhangxiaokang20190120.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bwei.android_zhangxiaokang20190120.R;

public class BaiDuMayActivity extends AppCompatActivity {
    private int time=2;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
             if (time>0){
                 mHandler.sendEmptyMessageDelayed(1,3000);
                 Toast.makeText(BaiDuMayActivity.this, "移动了当前位置", Toast.LENGTH_SHORT).show();
             }else {

             }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_du_may);
        mHandler.sendEmptyMessageDelayed(1,3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeMessages(time,this);
    }
}
