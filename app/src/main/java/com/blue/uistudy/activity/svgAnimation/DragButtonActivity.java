package com.blue.uistudy.activity.svgAnimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.blue.uistudy.R;

/**
 * @author ly
 * @version V1.0
 * @Package com.blue.uistudy.activity.svgAnimation
 * @Description: TODO(请输入一段描述)
 * @date 2016/8/12 16:37
 */
public class DragButtonActivity extends Activity {

    private ImageView mImgBtnDrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_drag_btn);
        mImgBtnDrag = (ImageView) findViewById(R.id.img_drag_btn);
        mImgBtnDrag.setOnTouchListener(new View.OnTouchListener(){
            private int mx, my;
            float firstX = 0;
            float firstY = 0;
            float lastX = 0;
            float lastY = 0;

            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        firstX = event.getX();
                        firstY = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        lastX = event.getX();
                        lastY = event.getY();
                        if (Math.abs(firstX - lastX) < 20) { //解决onclick事件和onTouch事件冲突
//                            ToastUtils.showMessage("onclick");
                            return false;// 距离较小，当作click事件来处理
                        }
                        if (Math.abs(firstY - lastY) > 60) {  // 真正的onTouch事件
                            mx = (int) (event.getRawX());
                            my = (int) (event.getRawY() - 50);
                            return true;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mx = (int)(event.getRawX());
                        my = (int)(event.getRawY() - 50);
                        //重新layoutmImgBtnDrag位置
                        mImgBtnDrag.layout(mx -mImgBtnDrag.getWidth() / 2, my - mImgBtnDrag.getHeight() / 2, mx + mImgBtnDrag.getWidth() / 2, my + mImgBtnDrag.getHeight() / 2);
                       //解决parent刷新，导致mImgBtnDrag还原初始位置的问题
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(v.getWidth(),v.getHeight());
                        params.leftMargin = v.getLeft();
                        params.topMargin = v.getTop();
                        params.rightMargin = v.getRight();
                        params.bottomMargin = v.getBottom();
                        mImgBtnDrag.setLayoutParams(params);
                        return  true;
                }
                return true;// 返回true，不执行click事件
            }

        });
    }
}
