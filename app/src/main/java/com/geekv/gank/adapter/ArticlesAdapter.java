package com.geekv.gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geekv.gank.R;
import com.geekv.gank.bean.Article;
import com.geekv.gank.constant.Constant;

import java.util.List;

/**
 * Created by hfl12 on 2016/3/13.
 */
public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.MyViewHolder> {
    Context context;
    LayoutInflater inflater;
    List<Article.Results>list;
    public ArticlesAdapter(Context context,List<Article.Results>list){
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(inflater.inflate(R.layout.articles_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Article.Results result=list.get(position);
        holder.tvTitle.setText(result.getDesc());
        holder.tvWho.setText(result.getWho());
        holder.tvTime.setText(result.getPublishedAt().split("T")[0]);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvWho,tvTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvTime= (TextView) itemView.findViewById(R.id.tv_time);
            tvTitle= (TextView) itemView.findViewById(R.id.tv_title);
            tvWho= (TextView) itemView.findViewById(R.id.tv_who);
        }
    }
}
