package com.blue.uistudy.adapter;

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
 * Created date on 2016/6/28 0028.
 * describe :xxxx
 * author : ly
 * email : 839482621@qq.com
 */
public class CustomAdsImgAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<AdsImage> mDatas = new ArrayList<AdsImage>();

    public CustomAdsImgAdapter(Context mContext, ArrayList<AdsImage> mDatas) {
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
        ViewHolder holder =null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_ads_img, null);
            holder = new ViewHolder(view);
          view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        AdsImage adsImage = mDatas.get(i);
        if(adsImage!=null){
            Glide.with(mContext).load(adsImage.getImage_url()).into(holder.imgAds);
        }
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.img_ads)
        ImageView imgAds;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
