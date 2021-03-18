package com.tzh.studydemo.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.tzh.studydemo.R;

public class MyLayout extends LinearLayout {

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        TypedValue sTmpValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.back, sTmpValue, true)) {
            Log.e("tzh","0");
        }
        Log.e("tzh"," sTmpValue.getFloat() : " +  sTmpValue.getFloat());
    }
}
