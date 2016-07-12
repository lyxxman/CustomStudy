package com.blue.uistudy.activity.Animation.customAnimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.blue.uistudy.R;
import com.blue.uistudy.customView.Rotate3dAnimation;
import com.blue.uistudy.utils.DensityUtil;

/**
 * @author ly
 * @version V1.0
 * @Package com.blue.uistudy.Animation.customAnimation
 * @Description: 自定义3dimagview旋转动画
 * @date 2016/7/8 13:29
 */
public class CustomAnimationActivity extends Activity {
    private ImageView mImgCustom3d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_ainmation);
        mImgCustom3d = (ImageView) findViewById(R.id.img_custom_ainmation);
        Rotate3dAnimation animation = new Rotate3dAnimation(Rotate3dAnimation.ROLL_BY_Y,0f,360f,mImgCustom3d.getX()+ DensityUtil.dip2px(this,50),mImgCustom3d.getY()+DensityUtil.dip2px(this,50));
        animation.setFillAfter(true);
        animation.setDuration(4000);
        animation.setRepeatCount(Animation.INFINITE);
        mImgCustom3d.startAnimation(animation);
    }
}
