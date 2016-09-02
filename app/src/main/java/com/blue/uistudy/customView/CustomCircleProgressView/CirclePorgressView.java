package com.blue.uistudy.customView.customCircleProgressView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.blue.uistudy.R;

/**
 * TODO: document your custom view class.
 */
public class CirclePorgressView extends View {
    private String mExampleString; // TODO: use a default from R.string...
    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
    private Drawable mExampleDrawable;

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;
    private Context mContext;
    public CirclePorgressView(Context context) {

        super(context);
        mContext = context;
        init(null, 0);
    }

    public CirclePorgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs, 0);
    }

    public CirclePorgressView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
    }


    @Override
    protected void onDraw(Canvas canvas) {


        Paint p = new Paint();
        p.setColor(mContext.getResources().getColor(R.color.green));
        p.setStyle(Paint.Style.STROKE);//设置空心
        RectF oval1=new RectF(150,20,180,40);
        canvas.drawArc(oval1, 270, 180, false, p);//小弧形

        super.onDraw(canvas);
    }



}
