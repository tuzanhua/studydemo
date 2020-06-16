package com.tzh.android.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CustomViewGroup extends LinearLayout {
    private static final String TAG = "CustomViewGroup";
    public CustomViewGroup(Context context) {
        this(context,null);
    }

    public CustomViewGroup(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        // if you want trigger  onDraw() you can do this setWillNotDraw(false);  or  setBackGround();
        setWillNotDraw(false);
        Log.e(TAG,"initview");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e(TAG,"onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG,"onLayout");
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG,"onDraw");
        super.onDraw(canvas);
    }
}
