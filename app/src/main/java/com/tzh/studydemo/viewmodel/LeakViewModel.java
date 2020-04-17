package com.tzh.studydemo.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.tzh.android.LogUtil;

/**
 * create by tuzanhua on 2020/4/16
 */
public class LeakViewModel extends AndroidViewModel {

    public MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    public LeakViewModel(@NonNull Application application) {
        super(application);
    }


    private FragmentActivity activity;

    public void setView(FragmentActivity view) {
        this.activity = view;
    }

    public void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    mutableLiveData.postValue("获取到数据了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onCleared() {
        LogUtil.e("onCleared");
    }
}
