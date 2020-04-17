package com.tzh.studydemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.tzh.android.LogUtil;
import com.tzh.designpattern.SingleInstance;
import com.tzh.studydemo.viewmodel.LeakViewModel;

/**
 * create by tuzanhua on 2020/4/16
 */
public class MakeLeakActivity extends FragmentActivity {
    private Bitmap bitmap = null;
    private ImageView imageView;
    private LeakViewModel leakViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeweak);
        imageView = findViewById(R.id.iv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.login_bg);
//                imageView.setImageBitmap(bitmap);


            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leakViewModel.getData();
                try {
                    Thread.sleep(2000);
//                    startActivity(new Intent(MakeLeakActivity.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        leakViewModel = new ViewModelProvider(this).get(LeakViewModel.class);
//        leakViewModel.setView(this);
        leakViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                LogUtil.e("onchange :" + s);
            }
        });

        Glide.with(this)
                .load(R.drawable.login_bg)
                .into(imageView);

    }

    @Override
    protected void onDestroy() {

//        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
//        rceycleBitmapDrawable(drawable);
//        imageView = null;
        super.onDestroy();
    }

    private  void rceycleBitmapDrawable(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            imageView.setImageDrawable(null);
            rceycleBitmap(bitmap);
        }
        bitmapDrawable = null;
    }

    private  void rceycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }
    }
}
