package com.tzh.studydemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.view.LayoutInflaterCompat;

import com.tzh.studydemo.R;

/**
 * create by tuzanhua on 2020/5/9
 */
public class ViewTouchActivity extends Activity {
    private static final String TAG = "ViewTouchActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new LayoutInflater.Factory2() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                return null;
            }

            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                return null;
            }
        });
        setContentView(R.layout.activity_viewtouch);
        LinearLayout mllParent = findViewById(R.id.ll_parent);
        int childCount = mllParent.getChildCount();
        Log.e("tzh", " childCount :" + childCount);
        for (int i = childCount - 1; i >= 0; i--) {
            Log.e("tzh", "child :" + mllParent.getChildAt(i).toString());
        }
    }
}
