package com.tzh.android.viewtouch;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.tzh.studydemo.R;

/**
 * create by tuzanhua on 2020/5/9
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        this(context,null);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e("tzh","MyRelativeLayout   constructor :" );
        inflate(context, R.layout.activity_bitmap,this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("tzh","MyRelativeLayout   dispatchTouchEvent :" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("tzh","MyRelativeLayout   onTouchEvent :" + event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e("tzh","MyRelativeLayout   onAttachedToWindow :" );
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e("tzh","MyRelativeLayout   onDetachedFromWindow :" );
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e("tzh","MyRelativeLayout   onFinishInflate :" );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("tzh","MyRelativeLayout   onSizeChanged :"  + "w =:" + w + "    h:=" + h +"   oldw = :" + oldw   + "    :oldh :" + oldh);
    }

    @Override
    public void draw(Canvas canvas) {
        Log.e("tzh","MyRelativeLayout   draw :" );
        super.draw(canvas);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.e("tzh","MyRelativeLayout   dispatchDraw :" );
        super.dispatchDraw(canvas);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("tzh","MyRelativeLayout   onDraw :" );
        super.onDraw(canvas);

    }
}
