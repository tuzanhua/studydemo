package com.tzh.studydemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tzh.studydemo.fragment.TzhReportFragment;
import com.tzh.studydemo.viewmodel.LifecycleViewModel;
import com.tzh.studydemo.viewmodel.LiveDataBus1;

/**
 * viewmodel  onCreate()
 */
public class LifecycleActivity extends FragmentActivity {
    private static final String TAG = "LifecycleActivity";
    private LifecycleViewModel lifecycleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Log.e(TAG, "fragmentmanager :  " + supportFragmentManager.toString());
        Fragment tzhreportfragment = supportFragmentManager.findFragmentByTag("tzhreportfragment");
        if (tzhreportfragment == null) {
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.add(new TzhReportFragment(), "tzhreportfragment").commit();
        }
        setContentView(R.layout.activity_lifecycle);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifecycleViewModel.lifecycleLiveData.setValue("send message");
                LiveDataBus.getInstance().with("demo").setValue(false);
                LiveDataBus1.getInstance().with("demo1").setValue(false);
//                startActivity(new Intent(LifecycleActivity.this, ViewTouchActivity.class));
            }
        });
        Log.e(TAG, "  onCreate  ");
        lifecycleViewModel = new ViewModelProvider(this).get(LifecycleViewModel.class);
        lifecycleViewModel.lifecycleLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, LifecycleActivity.this.toString() + "  onCreate  " + s);
            }
        });

        LiveDataBus.getInstance().with("demo", Boolean.class).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.e(TAG, LifecycleActivity.this.toString() + " LiveDataBus onCreate  " + aBoolean);
            }
        });

        LiveDataBus1.getInstance().with("demo1", Boolean.class).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.e(TAG, LifecycleActivity.this.toString() + " LiveDataBus1 onCreate  " + aBoolean);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "  onNewIntent  ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(TAG, "  onSaveInstanceState  ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "  onStart  ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "  onResume  ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "  onPause  ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "  onStop  ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "  onDestroy  ");
    }
}
