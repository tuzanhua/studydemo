package com.tzh.studydemo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tzh.android.THandlerThread.THandlerThread;
import com.tzh.android.TIntentService.TTestIntentService;

/**
 * create by tuzanhua on 2020/4/9
 */
public class HandlerBlockTestActivity extends AppCompatActivity {

    private static final String TAG = "HandlerBlockTestActivit";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 在这里睡 50S 程序会崩溃吗
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.e(TAG, "第二个handler 收到消息了");
        }
    };
    private TextView mTv;

    int i = 0;
    private ImageView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);
        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message obtain = Message.obtain();
                handler.sendEmptyMessage(0);
                mHandler.sendEmptyMessage(1);
            }
        });

        mTv = findViewById(R.id.tv_message);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setText(" " + i++);
            }
        });

        view = findViewById(R.id.view);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(view, "rotation", 0, 3600)
                        .setDuration(10000)
                        .start();
            }
        });

        TextView mTvThread = findViewById(R.id.tv_thread);
        findViewById(R.id.btn_handle_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                THandlerThread tHandlerThread = new THandlerThread("test_handler");
                tHandlerThread.start();
                Handler handler = new Handler(tHandlerThread.getMyLooper()){
                    @Override
                    public void handleMessage(Message msg) {
                        Log.e(TAG,Thread.currentThread().getName() + "msg");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                handler.sendEmptyMessage(0);
                handler.sendEmptyMessage(0);
                handler.sendEmptyMessage(0);
            }
        });

        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(HandlerBlockTestActivity.this, TTestIntentService.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
