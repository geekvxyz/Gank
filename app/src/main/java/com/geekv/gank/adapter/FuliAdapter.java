package com.geekv.gank.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.geekv.gank.R;
import com.geekv.gank.bean.Article;
import com.geekv.gank.bean.Meizi;
import com.geekv.gank.utils.ImageLoaderOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class FuliAdapter extends
        RecyclerView.Adapter<FuliAdapter.MyViewHolder>
{

    private List<Meizi.Results> mDatas;
    private LayoutInflater mInflater;
    DisplayImageOptions options;
    //private List<Integer> mHeights;
    ImageLoadingListenerImpl mImageLoadingListenerImpl;
    DisplayImageOptions mDisplayImageOptions;
    public interface OnItemClickLitener
    {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    private OnItemClickLitener listener;

    public  void setOnItemClickLitener(OnItemClickLitener listener)
    {
        this.listener =listener;
    }

    public FuliAdapter(Context context, List<Meizi.Results> datas)
    {
        mInflater = LayoutInflater.from(context);
        //options = ImageLoaderOptions.getChatAdapterOptions();
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        mDatas = datas;
        mDisplayImageOptions =ImageLoaderOptions.getOptions();

        mImageLoadingListenerImpl=new ImageLoadingListenerImpl();

        //mHeights = new ArrayList<Integer>();
        //for (int i = 0; i < mDatas.size(); i++)
       // {
          //  mHeights.add( (int) (100 + Math.random() * 300));
       // }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.item_meizi, parent, false));
        return holder;
    }
    public void addAll(List<Meizi.Results>lists){
        this.mDatas.addAll(lists);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        String ivUrl=mDatas.get(position).getUrl();
        holder.iv.setTag(ivUrl);
        if (holder.iv.getTag().toString().equals(ivUrl)) {
            ImageLoader.getInstance().displayImage(mDatas.get(position).getUrl(), holder.iv, mDisplayImageOptions, mImageLoadingListenerImpl);
        }
        //ImageLoader.getInstance().setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));//两个分别表示拖动下拉条和滑动过程中暂停加载



        holder.tv.setText(mDatas.get(position).getDesc());
        //holder.iv.setImageBitmap();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onClick(holder.itemView, position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (listener != null) {
                    listener.onLongClick(holder.itemView, position);
                }
                return false;
            }
        });
    }

    public static class ImageLoadingListenerImpl extends SimpleImageLoadingListener {

        public static final List<String> displayedImages =
                Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view,Bitmap bitmap) {
            if (bitmap != null) {
                ImageView imageView = (ImageView) view;
                boolean isFirstDisplay = !displayedImages.contains(imageUri);
                if (isFirstDisplay) {
                    //图片的淡入效果
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                    System.out.println("===> loading "+imageUri);
                }
            }
        }
    }
    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }



    public void removeData(int position)
    {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    class MyViewHolder extends ViewHolder
    {

        TextView tv;
        ImageView iv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_title);
            iv= (ImageView) view.findViewById(R.id.iv_meizi);
        }
    }
}