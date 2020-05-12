package com.tzh.studydemo.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tzh.studydemo.R;

/**
 * create by tuzanhua on 2020/4/21
 */
public class FlowLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tzh",getClass().getCanonicalName() + "   onresume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("tzh",getClass().getCanonicalName() + "   onStart");
    }
}
