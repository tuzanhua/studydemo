package com.tzh.studydemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tzh.android.customdrawable.BoarderDrawable;
import com.tzh.studydemo.R;

public class CustomViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        ImageView iv = findViewById(R.id.iv);
        iv.setImageDrawable(new BoarderDrawable());
    }
}
