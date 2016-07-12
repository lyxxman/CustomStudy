package com.blue.uistudy.customView;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created date on 2016/6/30 0030.
 * describe :xxxx
 * author : ly
 * email : 839482621@qq.com
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if(parent.getChildPosition(view) != 0)
            outRect.right =space;
    }

    public SpaceItemDecoration() {
        super();
    }
}
