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
}
