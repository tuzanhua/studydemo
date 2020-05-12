package com.tzh.studydemo.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.tzh.studydemo.R;

/**
 * create by tuzanhua on 2020/5/9
 */
public class ViewTouchActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtouch);
        LinearLayout mllParent = findViewById(R.id.ll_parent);
        int childCount = mllParent.getChildCount();
        Log.e("tzh", " childCount :" + childCount);
        for (int i = childCount - 1; i >= 0; i--) {
            Log.e("tzh", "child :" + mllParent.getChildAt(i).toString());
        }
    }
}
