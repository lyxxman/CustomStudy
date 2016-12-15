package com.blue.uistudy.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.blue.uistudy.R;
import com.blue.uistudy.entity.AdsImage;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author ly
 * @version V1.0
 * @Package com.blue.uistudy.activity.adapter
 * @Description: 临时数据适配器
 * @date 2016/9/28 16:49
 */
public class TempDataAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<AdsImage> mDatas = new ArrayList<AdsImage>();

    public TempDataAdapter(Context mContext, ArrayList<AdsImage> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_temp_data, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        AdsImage adsImage = mDatas.get(i);
        if(adsImage!=null){
            Glide.with(mContext).load(adsImage.getImage_url()).into(holder.imgItemTempData);
        }
        return view;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_temp_data.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @Bind(R.id.img_item_temp_data)
        ImageView imgItemTempData;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
