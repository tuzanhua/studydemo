package com.tzh.studydemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;

import com.tzh.studydemo.activity.FlowLayoutActivity;
import com.tzh.studydemo.activity.ViewTouchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_handler_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HandlerBlockTestActivity.class));
            }
        });

        findViewById(R.id.btn_start_leak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MakeLeakActivity.class));
            }
        });

        findViewById(R.id.btn_flow_layout).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));
        });

        findViewById(R.id.btn_view_touch).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ViewTouchActivity.class));
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("tzh", getClass().getCanonicalName() + "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("tzh", getClass().getCanonicalName() + "onStop");
    }
}
