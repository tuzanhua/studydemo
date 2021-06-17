package com.tzh.studydemo.activity;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class DemoViewmodel extends AndroidViewModel {
    public DemoViewmodel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {

        super.onCleared();
        Log.e("tzh","onCleared");
    }
}
