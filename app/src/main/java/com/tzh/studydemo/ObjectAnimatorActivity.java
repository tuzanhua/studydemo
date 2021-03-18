package com.tzh.studydemo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private View btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectanimator);
//        btn2 = findViewById(R.id.btn_2);
//        btn2.setOnClickListener(v -> {
//            ToastUtil.show(this,"点击了");
//            ObjectAnimator.ofFloat(btn2,"translationY",300,100).setDuration(2000).start();
//        });
//        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ObjectAnimator.ofFloat(btn2,"translationY",0,200).setDuration(2000).start();
//            }
//        });
//        findViewById(R.id.ml).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}
