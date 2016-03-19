package com.geekv.gank.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.geekv.gank.R;
import com.geekv.gank.adapter.ArticlesAdapter;
import com.geekv.gank.bean.Article;
import com.geekv.gank.ui.RecycleViewDivider;
import com.geekv.gank.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JSFragment extends Fragment {
    RecyclerView mRecyclerView;

    public JSFragment() {
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        HttpUtils.getqdArticles( new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                List<Article.Results> list;
                Article article = new Gson().fromJson(s, Article.class);
                list = article.getResults();
                Log.d("TAG", "得到数据：" + list);
                mRecyclerView.setAdapter(new ArticlesAdapter(getActivity(), list));
                mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),
                        LinearLayoutManager.VERTICAL));
            }
        });
    }


}
