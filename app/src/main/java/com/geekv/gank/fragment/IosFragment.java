package com.geekv.gank.fragment;



import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.Log;
import android.util.TypedValue;
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
import com.geekv.gank.ui.WebActivity;
import com.geekv.gank.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class IosFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    RecyclerView mRecyclerView;
    ArticlesAdapter adapter;
    SwipeRefreshLayout mSwipe;
    LinearLayoutManager mLayoutManager;
    int page=1;
    int lastVisibleItem;

    public IosFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mSwipe = (SwipeRefreshLayout) view.findViewById(R.id.swipe);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mSwipe.setColorSchemeColors(R.color.green, R.color.red, R.color.bule);
        mSwipe.setOnRefreshListener(this);
        // 这句话是为了，第一次进入页面的时候显示加载进度条
        mSwipe.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mSwipe.setRefreshing(true);
        HttpUtils.getiosArticles(page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                final List<Article.Results> list;
                Article article = new Gson().fromJson(s, Article.class);
                list = article.getResults();
                adapter = new ArticlesAdapter(getActivity(), list);
                mRecyclerView.setAdapter(adapter);
                mSwipe.setRefreshing(false);
                adapter.setOnItemClickLitener(new ArticlesAdapter.OnItemClickLitener() {
                    @Override
                    public void onClick(View view, int position) {
                        Intent intent = new Intent(getActivity(), WebActivity.class);
                        intent.putExtra("url", list.get(position).getUrl());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                });
            }
        });
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
                int totalItemCount = mLayoutManager.getItemCount();
                //lastVisibleItem >= totalItemCount - 4 表示剩下4个item自动加载，各位自由选择
                // dy>0 表示向下滑动
                boolean isLoadingMore = false;

                if (lastVisibleItem >= totalItemCount - 1 && dy > 0) {
                    if (isLoadingMore){
                        Toast.makeText(getActivity(), "已经到底了", Toast.LENGTH_LONG).show();
                    }else {
                        mSwipe.setRefreshing(true);
                        page+=1;
                        loadPage(page);//这里多线程也要手动控制isLoadingMore
                        //isLoadingMore = false;

                    }



                }
            }
        });
    }

    private void loadPage(int page) {

        HttpUtils.getiosArticles(page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                final List<Article.Results> list;
                Article article = new Gson().fromJson(s, Article.class);
                list = article.getResults();
                adapter.addAll(list);
                mSwipe.setRefreshing(false);
            }
        });
    }


    @Override
    public void onRefresh() {

        HttpUtils.getiosArticles(page, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                final List<Article.Results> list;
                Article article = new Gson().fromJson(s, Article.class);
                list = article.getResults();
                adapter.addAll(list);
                mSwipe.setRefreshing(false);

            }
        });

    }
}
