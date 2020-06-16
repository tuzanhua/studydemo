package com.tzh.studydemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class LifecycleViewModel extends AndroidViewModel {

    public MutableLiveData<String> lifecycleLiveData = new MutableLiveData<>();

    public LifecycleViewModel(@NonNull Application application) {
        super(application);
    }


}
