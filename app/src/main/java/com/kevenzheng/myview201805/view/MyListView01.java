package com.kevenzheng.myview201805.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by zhengjian on 2018/5/11.
 */

public class MyListView01 extends ListView {
    public MyListView01(Context context) {
        super(context);
    }

    public MyListView01(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //widthMeasureSpec包含两个信息  模式：2位  值：30位
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //解决显示不全的问题
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }
}
