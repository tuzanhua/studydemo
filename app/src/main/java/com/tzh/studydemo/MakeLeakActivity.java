package com.tzh.studydemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.tzh.designpattern.SingleInstance;

/**
 * create by tuzanhua on 2020/4/16
 */
public class MakeLeakActivity extends AppCompatActivity {
    private Bitmap bitmap = null;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeweak);
        imageView = findViewById(R.id.iv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SingleInstance.getInstance(MakeLeakActivity.this);
//                 bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.login_bg);
//                imageView.setImageBitmap(bitmap);


            }
        });


    }
}
