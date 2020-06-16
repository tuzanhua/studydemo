package com.tzh.studydemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.tzh.android.viewtouch.MyRelativeLayout;
import com.tzh.studydemo.R;

/**
 * create by tuzanhua on 2020/5/9
 */
public class ViewTouchActivity extends Activity {
    private static final String TAG = "ViewTouchActivity";

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

        MyRelativeLayout myRelativeLayout = findViewById(R.id.rl);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRelativeLayout.setWillNotDraw(false);

            }
        });

    }
}
