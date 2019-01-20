package com.bwei.android_zhangxiaokang20190120.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwei.android_zhangxiaokang20190120.R;
import com.bwei.android_zhangxiaokang20190120.fragment.OneFragment;
import com.bwei.android_zhangxiaokang20190120.fragment.TwoFragment;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwoActivity extends AppCompatActivity {

    //    @BindView(R.id.two_viewpager)
//    ViewPager twoViewpager;
    @BindView(R.id.two_title)
    TextView twoTitle;
    @BindView(R.id.two_price)
    TextView twoPrice;
    @BindView(R.id.view_pager)
    Banner viewPager;
    List<String> titles = new ArrayList<>();
    List<String> images = new ArrayList<>();
    @BindView(R.id.shop_btn)
    Button shopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String title = intent.getStringExtra("title");
        float price1 = intent.getFloatExtra("price", 0);
        image.split("");
        List<Fragment> list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        titles.add("1");
        titles.add("2");
        titles.add("3");

        viewPager.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
                imageLoader.displayImage((String) path, imageView);
            }
        });
        titles.add(title);
        images.add(image);
        viewPager.setImages(images);
        viewPager.setBannerTitles(titles);
        viewPager.start();
        twoTitle.setText(title);
        twoPrice.setText(price1 + "");
    }

    @OnClick(R.id.shop_btn)
    public void onViewClicked() {
        View view = View.inflate(this, R.layout.item_layout_btn, null);
        PopupWindow popupWindow = new PopupWindow(view,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        ImageView image=view.findViewById(R.id.qq_image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        popupWindow.showAtLocation(view,0,0,0);

    }
}
