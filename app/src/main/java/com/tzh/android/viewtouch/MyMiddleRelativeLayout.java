package com.tzh.android.viewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * create by tuzanhua on 2020/5/9
 */
public class MyMiddleRelativeLayout extends RelativeLayout {
    public MyMiddleRelativeLayout(Context context) {
        super(context);
    }

    public MyMiddleRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMiddleRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("tzh", "MyMiddleRelativeLayout    dispatchTouchEvent :" + event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return super.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("tzh", "MyMiddleRelativeLayout    onTouchEvent :" + event.getAction());
        return super.onTouchEvent(event);
    }
}
