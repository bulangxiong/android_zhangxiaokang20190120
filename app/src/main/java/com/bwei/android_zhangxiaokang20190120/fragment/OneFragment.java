package com.bwei.android_zhangxiaokang20190120.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.android_zhangxiaokang20190120.R;

/**
 * Created by zxk
 * on 2019/1/20 16:15
 * QQ:666666
 * Describe:
 */
public class OneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_item_fragment, container, false);

        return view;
    }
}
