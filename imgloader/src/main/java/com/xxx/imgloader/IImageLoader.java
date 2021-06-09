package com.xxx.imgloader;

import android.content.Context;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 *  定义抽象展示逻辑
 */
interface IImageLoader {

    void load(Context context, ImageView target);

    void load(AppCompatActivity activity, ImageView target);

    void load(Fragment fragment, ImageView target);
}
