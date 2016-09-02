package com.blue.uistudy.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blue.uistudy.activity.Animation.AnimationSetsActivity;
import com.blue.uistudy.activity.Animation.customAnimation.CustomAnimationActivity;
import com.blue.uistudy.R;
import com.blue.uistudy.activity.svgAnimation.DragButtonActivity;
import com.blue.uistudy.adapter.CustomViewRecyAdapter;
import com.blue.uistudy.entity.UiType;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushService;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements CustomViewRecyAdapter.MyItemClickListener {


    @Bind(R.id.recy_view_main_ls)
    RecyclerView mRecyViewMainLs;
    @Bind(R.id.img_common_header_left)
    ImageView mImgCommonHeaderLeft;
    @Bind(R.id.txt_header_title)
    TextView mTxtHeaderTitle;
    private CustomViewRecyAdapter mCustomViewRecyAdapter;
    private ArrayList<UiType> mDataUiTypes = new ArrayList<UiType>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
        Context context = getApplicationContext();
        XGPushManager.registerPush(context);
        XGPushManager.enableService(context, true);

        // 2.36（不包括）之前的版本需要调用以下2行代码
        Intent service = new Intent(context, XGPushService.class);
        context.startService(service);
    }

    private void initView() {
        mTxtHeaderTitle.setText("UiStudy");

        mRecyViewMainLs.setHasFixedSize(true);
        //set UiTypeAdapter
        mCustomViewRecyAdapter = new CustomViewRecyAdapter(this, mDataUiTypes);
        // use a linear layout manager
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyViewMainLs.setLayoutManager(mLayoutManager);
        mRecyViewMainLs.setAdapter(mCustomViewRecyAdapter);
        mCustomViewRecyAdapter.setMyItemClickListener(this);
//        testThread();
    }

    private void initData() {
        UiType uiType1 = new UiType("电影票卡片效果");
        UiType uiType2 = new UiType("横向滚动scrollview");
        UiType uiType3 = new UiType("属性动画效果");
        UiType uiType4 = new UiType("自定义动画");
        UiType uiType5 = new UiType("自定义加载进度条");
        UiType uiType6 = new UiType("SVG动画实践");
        UiType uiType7 = new UiType("拖拽悬浮按钮");
        UiType uiType8 = new UiType("圆形进度条");
        mDataUiTypes.add(uiType1);
        mDataUiTypes.add(uiType2);
        mDataUiTypes.add(uiType3);
        mDataUiTypes.add(uiType4);
        mDataUiTypes.add(uiType5);
        mDataUiTypes.add(uiType6);
        mDataUiTypes.add(uiType7);
        mDataUiTypes.add(uiType8);
    }

    @Override
    public void onItemClick(View view, int postion) {
        switch (postion) {
            case 0:
                startActivity(new Intent(this, KaQuanActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, HorizontalScrollViewActiviy.class));
                break;
            case 2:
                startActivity(new Intent(this, AnimationSetsActivity .class));
                break;
            case 3:
                startActivity(new Intent(this, CustomAnimationActivity.class));
                break;
            case 6:
                startActivity(new Intent(this, DragButtonActivity.class));
                break;
            case 7:
                startActivity(new Intent(this,CustomCirleProgressActivity.class));
                break;
        }
    }
}
