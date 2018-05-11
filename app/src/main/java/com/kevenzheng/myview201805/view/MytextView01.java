package com.kevenzheng.myview201805.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.kevenzheng.myview201805.R;

/**
 * Created by jianzheng on 2018/5/10.
 * <p>
 * 自定义属性就是做到配置不写死，比如我在TextView中text配置什么就显示什么，
 * textColor指定什么颜色就显示什么颜色等等，这些都是自定义属性。
 * 在res下的values目录下新建一个attrs.xml文件
 */

public class MytextView01 extends View {

    private int mColor;
    private String mText1 = "";
    private int mTextSize = 14;
    private Paint mPaint;


    //当在代码中进行创建的时候会调用这个构造函数
    // MyTextView textView=new MyTextView(this);
    public MytextView01(Context context) {
        this(context, null);
    }

    //在布局中创建的时候会调用这个构造函数
    public MytextView01(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //在布局中创建的时候，并且给此View指定了style的时候会调用这个构造函数
    public MytextView01(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取TypedArray
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MytextView01);
        //获取设置的文字
        mText1 = typedArray.getString(R.styleable.MytextView01_text);
        //获取设置的文字颜色
        mColor = typedArray.getColor(R.styleable.MytextView01_textColor, Color.BLACK);
        //获取设置的文字大小
        mTextSize = (int) typedArray.getDimension(R.styleable.MytextView01_textSize, mTextSize);
        //回收
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setTextSize(mTextSize);
    }

    /**
     * 自定义View的测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    // widthMeasureSpec包含两个信息  模式：2位  值：30位
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        //布局的宽高都是有这个方法指定
//        //指定控件的宽高，需要测量
//
//        //获取当前控件宽高的模式
//        int width_mode = MeasureSpec.getMode(widthMeasureSpec);//获取的是对应模式的两位
//        int heght_mode = MeasureSpec.getMode(heightMeasureSpec);
    //   int size = MeasureSpec.getSize(widthMeasureSpec);//获取的是代表值的30位
//
//
//        //MeasureSpec.EXACTLY 在布局中指定了确切的值 或者是match_parent fill_parent
//        //MeasureSpec.AT_MOST 在布局中指定了wrap_content
//        //MeasureSpec.UNSPECIFIED 尽可能的大（不常用）ListView，ScroolView 在测量子布局的时候会使用UNSPECIFIED
//        if (width_mode == MeasureSpec.AT_MOST) {
//
//        } else {
//
//        }
//
//    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Paint paint = new Paint();
        //画圆
//        canvas.drawCircle(3, 3, 2, paint);
        //画bitmap
        //canvas.drawBitmap();

        //画文本
//        canvas.drawText("", 4, 4, paint);

        canvas.drawText(mText1, 0, mText1.length(), 100, 100, mPaint);
    }

    /**
     * 处理和用户的交互，触摸屏幕
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //手指按下
            case MotionEvent.ACTION_DOWN:
                break;
            //手指抬起
            case MotionEvent.ACTION_UP:
                break;
            //手指移动
            case MotionEvent.ACTION_MOVE:
                break;
        }


        return super.onTouchEvent(event);
    }
}
