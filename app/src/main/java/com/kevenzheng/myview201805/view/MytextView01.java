package com.kevenzheng.myview201805.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
    private String mText1;
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
        //设置颜色
        mPaint.setColor(mColor);
        //设置画笔
        mPaint.setTextSize(mTextSize);
        //设置抗锯齿
        mPaint.setAntiAlias(true);
    }

    /**
     * 自定义View的测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    //widthMeasureSpec包含两个信息  模式：2位  值：30位
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //布局的宽高都是有这个方法指定
        //指定控件的宽高，需要测量

        //获取当前控件宽高的模式
        int width_mode = MeasureSpec.getMode(widthMeasureSpec);//获取的是对应模式的两位
        int heght_mode = MeasureSpec.getMode(heightMeasureSpec);

        //MeasureSpec.EXACTLY 在布局中指定了确切的值 或者是match_parent fill_parent
        //MeasureSpec.AT_MOST 在布局中指定了wrap_content
        //MeasureSpec.UNSPECIFIED 尽可能的大（不常用）ListView，ScroolView 在测量子布局的时候会使用UNSPECIFIED

        //确定的大小，不需要测量
        int width = MeasureSpec.getSize(widthMeasureSpec);//获取的是代表值的30位

        if (width_mode == MeasureSpec.AT_MOST) {
            //传入的是wrap_content需要进行测量
            //计算的宽度与字体的长度有关 与字体的小大 用画笔来测量
            Rect bounds = new Rect();
            //获取文本的Rect
            mPaint.getTextBounds(mText1, 0, mText1.length(), bounds);
            width = bounds.width() + getPaddingLeft() + getPaddingRight();

        }

        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (heght_mode == MeasureSpec.AT_MOST) {
            Rect bounds = new Rect();
            mPaint.getTextBounds(mText1, 0, mText1.length(), bounds);
            height = bounds.height() + getPaddingTop() + getPaddingBottom();
        }

        //设置控件的宽高
        setMeasuredDimension(width, height);

    }

    /**
     * baseline是基线，在Android中绘制文本都是从baseline处开始的，从baseline往上至至文本最高处的距离称之为ascent(上坡度)，
     * baseline至文本最低处的距离称之为descent(下坡度)。
     * top和bottom是绘制文本时在最外层留出的一些内边距。
     * baseline是基线，baseline以上是负值，baseline以下是正值，因此ascent和top都是负值，descent和bottom都是正值。
     * 文本的实际高度应该就是descent-asscent,但是一般都是以top-bottom作为文本的高度。
     * <p>
     * Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
     * int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
     *
     * @param canvas
     */
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

        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        canvas.drawText(mText1, getPaddingLeft(), getHeight() / 2 + dy, mPaint);
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
