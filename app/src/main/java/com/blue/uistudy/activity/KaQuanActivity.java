package com.blue.uistudy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blue.uistudy.R;
import com.blue.uistudy.customView.TextView.CouponDisplayView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created date on 2016/6/28 0028.
 * describe :卡券效果activity
 * author : ly
 * email : 839482621@qq.com
 */
public class KaQuanActivity extends Activity {


    @Bind(R.id.img_common_header_left)
    ImageView mImgCommonHeaderLeft;
    @Bind(R.id.txt_header_title)
    TextView mTxtHeaderTitle;
    @Bind(R.id.coupoDisplay_main)
    CouponDisplayView mCoupoDisplayMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_kaquan);
        ButterKnife.bind(this);
        mTxtHeaderTitle.setText("电影票卡券效果");
        mImgCommonHeaderLeft.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.img_common_header_left)
    public void onClick() {
     finish();
    }
}
