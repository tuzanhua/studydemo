package com.tzh.studydemo.fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TzhReportFragment extends Fragment {

    private static final String TAG = "TzhReportFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"   onCreate   ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"   onStart   ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"   onResume   ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"   onPause   ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"   onStop   ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"   onDestroy   ");
    }
}
