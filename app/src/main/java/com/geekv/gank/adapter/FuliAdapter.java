package com.geekv.gank.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
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
import com.geekv.gank.bean.Meizi;
import com.geekv.gank.utils.ImageLoaderOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class FuliAdapter extends
        RecyclerView.Adapter<FuliAdapter.MyViewHolder>
{

    private List<Meizi.Results> mDatas;
    private LayoutInflater mInflater;
    DisplayImageOptions options;
    //private List<Integer> mHeights;

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public  void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public FuliAdapter(Context context, List<Meizi.Results> datas)
    {
        mInflater = LayoutInflater.from(context);
        //options = ImageLoaderOptions.getChatAdapterOptions();
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        mDatas = datas;

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

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        String ivUrl=mDatas.get(position).getUrl();
        if (!ivUrl.equals(holder.iv.getTag())){
            holder.iv.setTag(ivUrl);
            ImageLoader.getInstance().displayImage(mDatas.get(position).getUrl(), holder.iv);
        }


        holder.tv.setText(mDatas.get(position).getDesc());
        //holder.iv.setImageBitmap();

        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    removeData(pos);
                    return false;
                }
            });
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