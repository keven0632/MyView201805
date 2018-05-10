package com.kevenzheng.myview201805.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jianzheng on 2018/5/10.
 */

public class MytextView01 extends View {

    //当在代码中进行创建的时候会调用这个构造函数
    // MyTextView textView=new MyTextView(this);
    public MytextView01(Context context) {
        super(context);
    }

    //在布局中创建的时候会调用这个构造函数
    public MytextView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //在布局中创建的时候，并且给此View指定了style的时候会调用这个构造函数
    public MytextView01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 自定义View的测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //布局的宽高都是有这个方法指定
        //指定控件的宽高，需要测量

        //获取当前控件宽高的模式
        int width_mode = MeasureSpec.getMode(widthMeasureSpec);
        int heght_mode = MeasureSpec.getMode(heightMeasureSpec);


        //MeasureSpec.EXACTLY 在布局中指定了确切的值 或者是match_parent
        //MeasureSpec.AT_MOST 在布局中指定了wrap_content
        //MeasureSpec.UNSPECIFIED 尽可能的大（不常用）ListView，ScroolView 在测量子布局的时候会使用UNSPECIFIED
        if (width_mode == MeasureSpec.AT_MOST) {

        } else {

        }

    }
}
