package com.blue.uistudy.activity.Animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.blue.uistudy.R;
import com.blue.uistudy.utils.DensityUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created date on 2016/6/29 0029.
 * describe :xxxx
 * author : ly
 * email : 839482621@qq.com
 */
public class AnimationSetsActivity extends Activity {
    @Bind(R.id.img_common_header_left)
    ImageView mImgCommonHeaderLeft;
    @Bind(R.id.txt_header_title)
    TextView mTxtHeaderTitle;
    @Bind(R.id.img_icons)
    ImageView mImgIcons;
    @Bind(R.id.img_icons_2)
    ImageView mImgIcons2;
    @Bind(R.id.img_icons_qiu)
    ImageView mImgIconsQiu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation_sets);
        ButterKnife.bind(this);
        initViewAnimationSets();
        translateAnimator();
    }

    //平移动画
    private void translateAnimator() {
        float initPositionTop = mImgIconsQiu.getY() - DensityUtil.dip2px(this, 50);
        float initPositionBottom = mImgIconsQiu.getY();
        TranslateAnimation alphaAnimation2 = new TranslateAnimation(0, 0, initPositionTop, initPositionBottom);
        alphaAnimation2.setDuration(800);
        alphaAnimation2.setRepeatCount(0);
        alphaAnimation2.setRepeatMode(Animation.REVERSE);
        alphaAnimation2.setInterpolator(new BounceInterpolator());//动画结束的时候弹起
        mImgIconsQiu.setAnimation(alphaAnimation2);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ObjectTranslate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        alphaAnimation2.start();

    }

    /**
     *
     */
    private void ObjectTranslate() {
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mImgIconsQiu, "translationX", DensityUtil.dip2px(this, 25));
        objectAnimator3.setDuration(500);
        objectAnimator3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                AlphaAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        objectAnimator3.start();
    }

    /**
     * 渐变动画
     */
    private void AlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
//        ScaleAnimation scaleAnimation = new ScaleAnimation();
        alphaAnimation.setDuration(1000);
        mImgIconsQiu.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }

    private void initViewAnimationSets() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImgIcons, "translationX", 300f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mImgIcons, "translationY", 300f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mImgIcons, "scaleX", 1f, 0.5f, 0.2f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mImgIcons, "scaleY", 1f, 0.5f, 0.2f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1500);
        set.playTogether(objectAnimator, objectAnimator3, objectAnimator1, objectAnimator2);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                mImgIcons.setVisibility(View.GONE);
                mImgIcons2.setVisibility(View.VISIBLE);
                startImgIconAinmation();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
//        mImgIcons.setB
    }

    private void startImgIconAinmation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mImgIcons2, "translationX", 300f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mImgIcons2, "translationY", 300f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mImgIcons2, "scaleX", 0f, 0.5f, 1f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mImgIcons2, "scaleY", 0f, 0.5f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1500);
        set.playTogether(objectAnimator, objectAnimator3, objectAnimator1, objectAnimator2);
        set.start();
    }

    private static void calculate(float[][] points) {
        float x1 = points[0][0];
        float y1 = points[0][1];
        float x2 = points[1][0];
        float y2 = points[1][1];
        float x3 = points[2][0];
        float y3 = points[2][1];

        final float a = (y1 * (x2 - x3) + y2 * (x3 - x1) + y3 * (x1 - x2))
                / (x1 * x1 * (x2 - x3) + x2 * x2 * (x3 - x1) + x3 * x3 * (x1 - x2));
        final float b = (y1 - y2) / (x1 - x2) - a * (x1 + x2);
        final float c = y1 - (x1 * x1) * a - x1 * b;

        System.out.println("-a->" + a + " b->" + b + " c->" + c);
    }
}
