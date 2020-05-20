package com.tzh.android.viewtouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * create by tuzanhua on 2020/5/9
 */
public class MyTextView extends AppCompatTextView {


    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("tzh", "MyTextView   dispatchTouchEvent :" + event.getAction());

        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("tzh", "MyTextView   onTouchEvent :" + event.getAction());
        return true;
    }
}
