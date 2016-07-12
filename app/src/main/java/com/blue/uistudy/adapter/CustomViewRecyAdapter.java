package com.blue.uistudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blue.uistudy.R;
import com.blue.uistudy.entity.UiType;

import java.util.ArrayList;

/**
 * Created date on 2016/6/27 0027.
 * describe :xxxx
 * author : ly
 * email : 839482621@qq.com
 */
public class CustomViewRecyAdapter extends RecyclerView.Adapter<CustomViewRecyAdapter.CustomViewLsHolder> {
    Context mContext;
    private ArrayList<UiType> mDatas =new ArrayList<UiType>();
    private MyItemClickListener myItemClickListener;

    public CustomViewRecyAdapter(Context mContext, ArrayList<UiType> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public CustomViewLsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CustomViewLsHolder customViewLsHolder = new CustomViewLsHolder(LayoutInflater.from(mContext).inflate(R.layout.item_custom_view_ls,parent,false));
        return customViewLsHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewLsHolder holder, final int position) {
    holder.mTxtCustomTilte.setText(mDatas.get(position).getName());
    holder.mCardRoot.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
           if(myItemClickListener!=null){
               myItemClickListener.onItemClick(view,position);
           }
        }
    });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class CustomViewLsHolder extends RecyclerView.ViewHolder {
        TextView mTxtCustomTilte;
        View mCardRoot;
        public CustomViewLsHolder(View itemView) {
            super(itemView);
            mTxtCustomTilte = (TextView) itemView.findViewById(R.id.txt_custom);
            mCardRoot = itemView.findViewById(R.id.card_root);
        }
    }

    public MyItemClickListener getMyItemClickListener() {
        return myItemClickListener;
    }

    public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
        this.myItemClickListener = myItemClickListener;
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, int postion);
    }
}
