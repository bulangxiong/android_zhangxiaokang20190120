package com.bwei.android_zhangxiaokang20190120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.android_zhangxiaokang20190120.R;
import com.bwei.android_zhangxiaokang20190120.bean.CarBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxk
 * on 2019/1/20 14:35
 * QQ:666666
 * Describe:
 */
public class CarAdapter extends BaseAdapter {
    private List<CarBean> list=new ArrayList<>();
    private Context context;

    public CarAdapter(Context context) {
        this.context = context;
    }
    public void addItem(List<CarBean> carBeans){
        if (carBeans != null) {
            list.addAll(carBeans);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView == null) {
           convertView=View.inflate(context, R.layout.item_layout,null);
            holder=new ViewHolder();
            holder.titlte=convertView.findViewById(R.id.item_title);
            holder.price=convertView.findViewById(R.id.item_price);
            holder.simpleDraweeView=convertView.findViewById(R.id.item_simple_iamge);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        CarBean carBean = list.get(position);
        holder.titlte.setText(carBean.getTitle());
        holder.price.setText(carBean.getPrice()+"");
        String images = carBean.getImages();
        String[] split = images.split("//|");
        holder.simpleDraweeView.setImageURI(split[0]);
        return convertView;
    }

    class ViewHolder{
        TextView titlte;
        TextView price;
        SimpleDraweeView simpleDraweeView;
    }
}
