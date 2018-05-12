package com.kevenzheng.myview201805.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.kevenzheng.myview201805.R;

/**
 * Created by jianzheng on 2018/5/12.
 */

public class MyTextView001 extends View {

    private int mTextSize;
    private String mText;
    private int mText_color;
    private Paint mPaint;

    public MyTextView001(Context context) {
        this(context, null);
    }

    public MyTextView001(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView001(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView001);
        mTextSize = (int) typedArray.getDimension(R.styleable.MyTextView001_text_size01, 12);
        mText = typedArray.getString(R.styleable.MyTextView001_text01);
        mText_color = typedArray.getColor(R.styleable.MyTextView001_text_color01, Color.BLACK);

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mText_color);
        //抗锯齿
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取宽高模式
        int width_mode = MeasureSpec.getMode(widthMeasureSpec);
        int height_mode = MeasureSpec.getMode(heightMeasureSpec);
        //获取宽度
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (width_mode == MeasureSpec.AT_MOST) {
            //如果使用 wrap_content 模式，则重新计算宽度
            Rect rect = new Rect();
            mPaint.getTextBounds(mText, 0, mText.length(), rect);
            width = rect.width()+getPaddingLeft()+getPaddingRight();

        }
        //获取高度
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (height_mode == MeasureSpec.AT_MOST) {
            //如果使用 wrap_content 模式，则重新计算高度
            Rect rect = new Rect();
            mPaint.getTextBounds(mText, 0, mText.length(), rect);
            height = rect.height()+getPaddingTop()+getPaddingBottom();
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //计算baseLine
        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom - fontMetricsInt.top) / 2 - fontMetricsInt.bottom;
        canvas.drawText(mText, getPaddingLeft(), getHeight() / 2 + dy, mPaint);

    }
}
