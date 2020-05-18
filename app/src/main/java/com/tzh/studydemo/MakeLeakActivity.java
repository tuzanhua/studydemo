package com.tzh.studydemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.tzh.android.LogUtil;
import com.tzh.studydemo.viewmodel.LeakViewModel;

/**
 * create by tuzanhua on 2020/4/16
 */
public class MakeLeakActivity extends FragmentActivity {
    private Bitmap bitmap = null;
    private ImageView imageView;
    private LeakViewModel leakViewModel;
    private Handler handler;
    private HandlerThread handlerThread;


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


        handlerThread = new HandlerThread("leak");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                LogUtil.e("我造成的内存泄漏");
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        };
        handler.sendEmptyMessageDelayed(0, 2000);


    }

    @Override
    protected void onDestroy() {

//        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
//        rceycleBitmapDrawable(drawable);
//        imageView = null;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        super.onDestroy();
    }

    private void rceycleBitmapDrawable(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable != null) {
            Bitmap bitmap = bitmapDrawable.getBitmap();
            imageView.setImageDrawable(null);
            rceycleBitmap(bitmap);
        }
        bitmapDrawable = null;
    }

    private void rceycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }
    }
}
