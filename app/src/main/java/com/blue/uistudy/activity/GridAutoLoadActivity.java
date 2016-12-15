package com.blue.uistudy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.blue.uistudy.R;
import com.blue.uistudy.activity.adapter.TempDataAdapter;
import com.blue.uistudy.entity.AdsImage;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author ly
 * @version V1.0
 * @Package com.blue.uistudy.activity
 * @Description: 自动加载网格布局Activity
 * @date 2016/9/28 16:39
 */
public class GridAutoLoadActivity extends Activity {
    @Bind(R.id.img_common_header_left)
    ImageView mImgCommonHeaderLeft;
    @Bind(R.id.txt_header_title)
    TextView mTxtHeaderTitle;
    @Bind(R.id.grid_lv_auto_data)
    GridView mGridLvAutoData;
    TempDataAdapter mTempDataAdapter;
    ArrayList<AdsImage> mAdsImages = new ArrayList<AdsImage>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_grid_auto_load);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        mTxtHeaderTitle.setText("网格布局");
        mTempDataAdapter = new TempDataAdapter(getApplicationContext(), mAdsImages);
        mGridLvAutoData.setAdapter(mTempDataAdapter);
        AdsImage adsImage = new AdsImage("http://img.hb.aicdn.com/d2024a8a998c8d3e4ba842e40223c23dfe1026c8bbf3-OudiPA_fw580");
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mAdsImages.add(adsImage);
        mTempDataAdapter.notifyDataSetChanged();
    }
    private void initEvent(){

    }
}
