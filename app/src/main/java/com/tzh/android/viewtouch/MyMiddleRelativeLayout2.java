package com.tzh.android.viewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * create by tuzanhua on 2020/5/9
 */
public class MyMiddleRelativeLayout2 extends RelativeLayout {

    private float x;

    public MyMiddleRelativeLayout2(Context context) {
        super(context);
    }

    public MyMiddleRelativeLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMiddleRelativeLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("tzh", "MyMiddleRelativeLayout 2   dispatchTouchEvent :" + event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return super.dispatchTouchEvent(event);

            case MotionEvent.ACTION_MOVE:

                break;

        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("tzh", "MyMiddleRelativeLayout 2   onInterceptTouchEvent :" + ev.getAction());
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            x = ev.getX();
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            float newX = ev.getX();
            if (Math.abs(newX - x) > 300) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("tzh", "MyMiddleRelativeLayout 2   onTouchEvent :" + event.getAction());
        return super.onTouchEvent(event);
    }
}
