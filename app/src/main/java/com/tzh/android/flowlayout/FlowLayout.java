package com.tzh.android.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.tzh.android.LogUtil;

/**
 * create by tuzanhua on 2020/4/20
 */
public class FlowLayout extends ViewGroup {

    // widthMeasureSpec  mode  是由 父类和自己的layoutparams 共同决定的  UNSPECIFIED 在外层有 scrollview 的时候 高的params  如果没有给定具体的值 就会是 UNSPECIFIED

    private int horizatalspace = 50;
    private int verticalspace = 100;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                LogUtil.e("width mode : EXACTLY");
                break;
            case MeasureSpec.AT_MOST:
                LogUtil.e("width mode : AT_MOST");
                break;
            case MeasureSpec.UNSPECIFIED:
                LogUtil.e("width mode : UNSPECIFIED");
                break;
        }

        switch (mode1) {
            case MeasureSpec.EXACTLY:
                LogUtil.e("height mode : EXACTLY");
                break;
            case MeasureSpec.AT_MOST:
                LogUtil.e("height mode : AT_MOST");
                break;
            case MeasureSpec.UNSPECIFIED:
                LogUtil.e("height mode : UNSPECIFIED");
                break;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
