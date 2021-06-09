package com.tzh.studydemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tzh.android.bitmap.BitmappoolActivity;
import com.tzh.studydemo.activity.DanmuActivity;
import com.tzh.studydemo.activity.FlowLayoutActivity;
import com.tzh.studydemo.activity.OLActivity;
import com.tzh.studydemo.activity.ViewTouchActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<>();
    private Handler handler;

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

        findViewById(R.id.btn_imageview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BitmappoolActivity.class));
            }
        });

        findViewById(R.id.btn_lifecycle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifecycleActivity.class));
            }
        });

        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 Intent intent = new Intent(Intent.ACTION_SEND);
//                 intent.setType("text/plain");
//                 intent.putExtra(Intent.EXTRA_TEXT, "hello");
//                MainActivity.this.startActivity(Intent.createChooser(intent, "moon"));

                Intent mulIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                mulIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, new ArrayList<>());
                mulIntent.setType("image/jpeg");
                MainActivity.this.startActivity(Intent.createChooser(mulIntent, "多图文件分享"));
            }
        });

        findViewById(R.id.re).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DanmuActivity.class));
            }
        });

        findViewById(R.id.ol).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OLActivity.class));
            }
        });

        findViewById(R.id.launch_mode1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Mode1Activity.class));
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("tzh", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("blog", "www.gityuan.com");
        editor.putInt("years", 3);
        editor.commit();
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

    // 需要获得READ_PHONE_STATE权限，>=6.0，默认返回null
    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("MissingPermission")
    public static String getIMEI(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager)
                    context.getSystemService(Context.TELEPHONY_SERVICE);
            return tm.getImei();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
