package com.kevenzheng.myview201805.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.kevenzheng.myview201805.R;


/**
 * Created by jianzheng on 2018/5/12.
 */

public class MyProgressView03 extends View {

    private int background_color = Color.BLUE;
    private float text_size = 10;
    private int max_num = 1000;
    private int text_color = Color.RED;
    private int progress_color = Color.RED;
    private int defalt_width = 100;
    private int defalt_height = 100;
    private Paint backPaint;
    private int strokeWidth = 50;
    private Paint textPaint;
    private String mText = "100";
    private Paint progressPaint;
    private int mProgress = 100;


    public MyProgressView03(Context context) {
        this(context, null);
    }

    public MyProgressView03(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyProgressView03(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyProgressView03);
        background_color = typedArray.getColor(R.styleable.MyProgressView03_backgroud_color, Color.RED);
        progress_color = typedArray.getColor(R.styleable.MyProgressView03_progress_color, Color.YELLOW);
        text_color = typedArray.getColor(R.styleable.MyProgressView03_text_color, Color.RED);
        text_size = typedArray.getDimension(R.styleable.MyProgressView03_text_size, 15);
        max_num = typedArray.getInt(R.styleable.MyProgressView03_max_num, 1000);
        mText = typedArray.getString(R.styleable.MyProgressView03_text03);


        typedArray.recycle();

        initPaint();
    }

    private void initPaint() {
        backPaint = new Paint();
        backPaint.setAntiAlias(true);
        backPaint.setColor(background_color);
        backPaint.setStyle(Paint.Style.STROKE);
        backPaint.setStrokeWidth(strokeWidth);
        //设置为ROUND
        backPaint.setStrokeCap(Paint.Cap.ROUND);
        backPaint.setStrokeJoin(Paint.Join.ROUND);

        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setColor(progress_color);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(strokeWidth);
        //设置为ROUND
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        progressPaint.setStrokeJoin(Paint.Join.ROUND);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(text_color);
        textPaint.setTextSize(text_size);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width_mode = MeasureSpec.getMode(widthMeasureSpec);
        int height_mode = MeasureSpec.getMode(heightMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (height_mode == MeasureSpec.AT_MOST) {
            height = defalt_height;
        }

        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (width_mode == MeasureSpec.AT_MOST) {
            width = defalt_width;
        }
        setMeasuredDimension(width, height);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int cenX = getWidth() / 2;
        int cenY = getHeight() / 2;

        int radius = cenX - strokeWidth;

        RectF rect = new RectF(cenX - radius, cenY - radius, cenX + radius, cenY + radius);
//        canvas.drawCircle(getWidth()/2,getHeight()/2,defalt_height/2,backPaint);

        canvas.drawArc(rect, 150, 240, false, backPaint);

        Rect rect1 = new Rect();
        textPaint.getTextBounds(mText, 0, mText.length(), rect1);
        canvas.drawText(mProgress+"", cenX - rect1.width() / 2, cenY + radius / 7, textPaint);

        int angle = 240 * mProgress / max_num;
        canvas.drawArc(rect, 150, angle, false, progressPaint);
    }

    public void setProgress(int progress) {
        if (progress < 0) {
            mProgress = 0;
        } else if (progress >= max_num) {
            mProgress = max_num;
        } else {
            mProgress = progress;
        }
        mText = progress + "";

        setMoveEngiSpeed(this, "", 0, progress);
    }

    public void setMoveEngiSpeed(final View carbody_car_speedview, String mCarbody_car_speedview, int velocity, double speed) {
        ObjectAnimator animator = ObjectAnimator.ofInt(carbody_car_speedview, mCarbody_car_speedview,
                velocity, (int) speed);
        animator.setDuration(2000).setInterpolator(new LinearInterpolator());
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (int) animation.getAnimatedValue();
//                carbody_car_speedview.setVelocity(value);
                invalidate();


            }
        });
        animator.start();
    }
}
