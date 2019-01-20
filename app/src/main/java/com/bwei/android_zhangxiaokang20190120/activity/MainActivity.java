package com.bwei.android_zhangxiaokang20190120.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.bwei.android_zhangxiaokang20190120.R;
import com.bwei.android_zhangxiaokang20190120.adapter.CarAdapter;
import com.bwei.android_zhangxiaokang20190120.bean.CarBean;
import com.bwei.android_zhangxiaokang20190120.bean.Result;
import com.bwei.android_zhangxiaokang20190120.core.DataCall;
import com.bwei.android_zhangxiaokang20190120.core.IRequest;
import com.bwei.android_zhangxiaokang20190120.http.HttpUtils;
import com.bwei.android_zhangxiaokang20190120.presenter.CarPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text_user_ju)
    TextView textUserJu;
    @BindView(R.id.recycler_view)
    ListView recyclerView;
    private CarAdapter adapter;
    private List<CarBean> data;
    CarPresenter carPresenter=new CarPresenter(new Caa());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new CarAdapter(this);
        recyclerView.setAdapter(adapter);

        IRequest iRequest = HttpUtils.getHttpUtils().create(IRequest.class);
        iRequest.searchProducts("手机",1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result<List<CarBean>>>() {
                    @Override
                    public void accept(Result<List<CarBean>> listResult) throws Exception {
                        data = listResult.getData();
                        adapter.addItem(data);
                        adapter.notifyDataSetChanged();
                    }
                });
         recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                 CarBean carBean = data.get(position);
                 intent.putExtra("image",carBean.getImages());
                 intent.putExtra("price",carBean.getPrice());
                 intent.putExtra("title",carBean.getTitle());
                 startActivity(intent);
             }
         });
         recyclerView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
             @Override
             public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                  data.remove(position);
                  adapter.notifyDataSetChanged();
                 return true;
             }
         });
         init();
    }

    private void init() {
        carPresenter.request("手机",1);
    }

    @OnClick(R.id.text_user_ju)
    public void onViewClicked() {
        Intent intent=new Intent(this,BaiDuMayActivity.class);
        startActivity(intent);
    }

    private class Caa implements DataCall  {
        @Override
        public void loadSuccess(Result result) {
            adapter = new CarAdapter(MainActivity.this);
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void loadError(Throwable throwable) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        carPresenter.unbind();
    }
}
