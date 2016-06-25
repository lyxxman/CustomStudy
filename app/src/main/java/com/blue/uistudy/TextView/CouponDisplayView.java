package com.blue.uistudy.TextView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.blue.uistudy.R;

/**
 * Created date on 2016/6/24 0024.
 * describe :卡卷效果
 * author : ly
 * email : 839482621@qq.com
 */
public class CouponDisplayView extends LinearLayout {

    private Paint mPaint;
    //圆间间距
    private float mCircleGap = 8;
    //圆的半径
    private float mCircleRadius = 10;
    //圆圈数
    private int mCircleNum =0;
    //剩余间距
    private float mRemain;
    public CouponDisplayView(Context context) {
        super(context);
    }

    public CouponDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.CouponDisplayView);
        mCircleRadius = typedArray.getDimension(R.styleable.CouponDisplayView_CircleRadius,10);
        mCircleGap = typedArray.getDimension(R.styleable.CouponDisplayView_CircleGap,10);
    }

    public CouponDisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(mRemain==0){
            mRemain = (w-mCircleGap)%(2*mCircleRadius+mCircleGap);
        }
        mCircleNum = (int) ((w-mCircleGap)/(2*mCircleRadius+mCircleGap));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<mCircleNum;i++){
            float x = mCircleGap+mCircleRadius+mRemain/2+((mCircleGap+mCircleRadius*2)*i);
            canvas.drawCircle(x,0,mCircleRadius,mPaint);
            canvas.drawCircle(x,getHeight(),mCircleRadius,mPaint);
        }
    }
}
