package com.geekv.gank.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.geekv.gank.R;
import com.geekv.gank.adapter.ArticlesAdapter;
import com.geekv.gank.adapter.FuliAdapter;
import com.geekv.gank.bean.Article;
import com.geekv.gank.bean.Meizi;
import com.geekv.gank.ui.RecycleViewDivider;
import com.geekv.gank.ui.SpacesItemDecoration;
import com.geekv.gank.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuliFragment extends Fragment {
    RecyclerView mRecyclerView;
    FuliAdapter adapter;
    List<Meizi.Results>meizi;
    public FuliFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);
        return  view;
    }

    private void initView(View view) {
        mRecyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setHasFixedSize(true);
        HttpUtils.getTypeArticles("福利", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                List<Meizi.Results> list;
                Meizi article = new Gson().fromJson(s, Meizi.class);
                list = article.getResults();
                Log.d("TAG", "得到数据：" + list);
                mRecyclerView.setAdapter(new FuliAdapter(getActivity(), list));
                //initEvent();
                SpacesItemDecoration decoration=new SpacesItemDecoration(16);
                mRecyclerView.addItemDecoration(decoration);


            }

            private void initEvent(){}


        });
    }


}
