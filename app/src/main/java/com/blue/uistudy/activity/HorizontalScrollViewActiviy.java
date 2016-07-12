package com.blue.uistudy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blue.uistudy.R;
import com.blue.uistudy.adapter.CustomAdsImgAdapter;
import com.blue.uistudy.customView.NoScrollGridView;
import com.blue.uistudy.entity.AdsImage;
import com.blue.uistudy.customView.pullToRefresh.PullToRefreshBase;
import com.blue.uistudy.customView.pullToRefresh.PullToRefreshHorizontalScrollView;
import com.blue.uistudy.utils.DensityUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created date on 2016/6/28 0028.
 * describe :xxxx
 * author : ly
 * email : 839482621@qq.com
 */
public class HorizontalScrollViewActiviy extends Activity implements PullToRefreshBase.OnRefreshListener2{

    @Bind(R.id.img_common_header_left)
    ImageView mImgCommonHeaderLeft;
    @Bind(R.id.txt_header_title)
    TextView mTxtHeaderTitle;
    @Bind(R.id.grid_lv_ads_imges)
    NoScrollGridView mGridLvAdsImges;
    @Bind(R.id.pull_refresh_horizontalscrollview)
    PullToRefreshHorizontalScrollView mPullRefreshHorizontalscrollview;

    CustomAdsImgAdapter mCustomAdsImgAdapter;
    /**
     * 广告数据集合
     */
    private ArrayList<AdsImage> mAdsImgDatas =new ArrayList<AdsImage>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_horizontal_scollview);
        ButterKnife.bind(this);
        initView();
    }
    private void initView(){
        mPullRefreshHorizontalscrollview.setMode(PullToRefreshBase.Mode.PULL_FROM_END_DISABLED_ARROW);
        AdsImage adsImage = new AdsImage("http://image.ganjiuhui.com/Image/TenFamousWineImg/2015/11/07_060959083_1.jpg");
        mAdsImgDatas.add(adsImage);
        mAdsImgDatas.add(adsImage);
        mAdsImgDatas.add(adsImage);
        mAdsImgDatas.add(adsImage);
        mAdsImgDatas.add(adsImage);
        mAdsImgDatas.add(adsImage);
        updateGsZiZhiGrid();
        mCustomAdsImgAdapter = new CustomAdsImgAdapter(this,mAdsImgDatas);
        mGridLvAdsImges.setAdapter(mCustomAdsImgAdapter);
        mCustomAdsImgAdapter.notifyDataSetChanged();
        mPullRefreshHorizontalscrollview.setOnRefreshListener(this);

    }
    @OnClick({R.id.img_common_header_left, R.id.txt_header_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_common_header_left:
                finish();
                break;
            case R.id.txt_header_title:
                break;
        }
    }
    /**
     * 更新公司资质Grid信息
     */
    private void updateGsZiZhiGrid() {
        int size = mAdsImgDatas.size();
        int width = DensityUtil.getWidthInPx(this) - DensityUtil.dip2px(this, 35);
        int length = (int) (width / 3.4);
        int gridviewWidth = size * length + (size - 1) * DensityUtil.dip2px(this, 10);
        int itemWidth = length;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
       mGridLvAdsImges.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        mGridLvAdsImges.setColumnWidth(itemWidth); // 设置列表项宽
        mGridLvAdsImges.setHorizontalSpacing(DensityUtil.dip2px(this, 10));
        mGridLvAdsImges.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        mGridLvAdsImges.setNumColumns(size); // 设置列数量=列表集合数
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        Toast.makeText(this,"提示2",3000).show();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        Toast.makeText(this,"提示1",3000).show();
        mPullRefreshHorizontalscrollview.onRefreshComplete();
    }
}
