package com.tzh.studydemo.activity;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

public class FixWidthAndHeightLayout extends RelativeLayout {

    public FixWidthAndHeightLayout(Context context) {
        this(context, null);
    }

    public FixWidthAndHeightLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FixWidthAndHeightLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = getMeasuredHeight();
                } else {
                    // exception
                }
            }
        });
    }
}
