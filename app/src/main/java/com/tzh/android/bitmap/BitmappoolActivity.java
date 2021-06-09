package com.tzh.android.bitmap;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tzh.studydemo.R;

import java.util.ArrayList;
import java.util.List;

public class BitmappoolActivity extends AppCompatActivity {

    private ImageView mIv1;
    private ImageView mIv2;
    private float density;

    private Bitmap bitmap;
    private ActivityManager activityManager;

    List<Bitmap> bitmapPool = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        DisplayMetrics displayMetrics1 = getResources().getDisplayMetrics();
        density = displayMetrics1.density;
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inJustDecodeBounds = true;
//                BitmapFactory.decodeResource(getResources(), R.drawable.login_bg4, options);
//                int height = options.outHeight;
//                int width = options.outWidth;
//
//                if (height > 200 * density && width > 200 * density) {
//                    double v1 = height * 1.0 / (200 * density);
//                    double v2 = width * 1.0 / (200 * density);
//                    if (v1 > v2) {
//                        options.inSampleSize = (int) v1;
//                    } else {
//                        options.inSampleSize = (int) v2;
//                    }
//                    Log.e("tzh", " in samplesize :" + options.inSampleSize);
//                }
//                options.inJustDecodeBounds = false;


                logVm(memoryInfo);

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable = true;
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.login_bg4, options);
                bitmapPool.add(bitmap);
                mIv1.setImageBitmap(bitmap);


//                Bitmap bitmap = Bitmap.createBitmap(53000,10000, Bitmap.Config.ARGB_8888);

//                1 Byte = 8 Bits（即 1B=8b）
//                1 KB = 1024 Bytes
//                1 MB = 1024 KB
//                1 GB = 1024 MB
                // 一个像素点 32 位  4个 byte 894 * 1334 *4 / 1024 / 1024
//                Bitmap bitmap = Bitmap.createBitmap(1024,   1024 * 200, Bitmap.Config.ARGB_8888);
//
                logVm(memoryInfo);
//
//                Canvas canvas = new Canvas(bitmap);
//                canvas.drawColor(Color.RED);
//                Log.e("tzh", "memoryInfo.availMem :" + memoryInfo.availMem / 1024 / 1024);
//                Log.e("tzh", "NativeHeapAllocatedSize :" + Debug.getNativeHeapAllocatedSize() / 1024 / 1024);
            }
        });
        mIv1 = findViewById(R.id.iv_1);
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logVm(memoryInfo);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(getResources(), R.drawable.login_bg, options);
                for (Bitmap singleBitmap : bitmapPool) {
                    if (canUseInBitmap(singleBitmap, options)) {
//                        bitmapPool.remove(singleBitmap);
                        options.inMutable = true;
                        options.inBitmap = singleBitmap;
                        Log.e("tzh", "复用了");
                        break;
                    }
                }
                options.inJustDecodeBounds = false;
                Bitmap bitmapTwo = BitmapFactory.decodeResource(getResources(), R.drawable.login_bg, options);
                logVm(memoryInfo);
                mIv2.setImageBitmap(bitmapTwo);
            }
        });
        mIv2 = findViewById(R.id.iv_2);
    }

    private void logVm(ActivityManager.MemoryInfo memoryInfo) {
        Log.e("tzh", "memoryInfo.availMem :" + memoryInfo.availMem / 1024 / 1024);
        Log.e("tzh", "NativeHeapAllocatedSize :" + Debug.getNativeHeapAllocatedSize() / 1024 / 1024);
    }

    public boolean canUseInBitmap(Bitmap reuseBitmap, BitmapFactory.Options targetOptions) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 4.4+
            int width = targetOptions.outWidth / (targetOptions.inSampleSize == 0 ? 1 : targetOptions.inSampleSize);
            int height = targetOptions.outHeight / (targetOptions.inSampleSize == 0 ? 1 : targetOptions.inSampleSize);
            int byteCount = width * height * getDim(reuseBitmap.getConfig());

            try {
                // getAllocationByteCount API 19 添加的 获取的值可能比 下面的值大
                return byteCount <= reuseBitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
                return byteCount <= reuseBitmap.getHeight() * reuseBitmap.getRowBytes();
            }
        }
        // API 18 前
        return reuseBitmap.getWidth() == targetOptions.outWidth
                && reuseBitmap.getHeight() == targetOptions.outHeight
                && targetOptions.inSampleSize == 1;
    }

    private static int getDim(Bitmap.Config config) {
        if (config == null) {
            return 4;
        }
        switch (config) {
            case ALPHA_8:
            default:
                return 1;
            case RGB_565:
            case ARGB_4444:
                return 2;
            case ARGB_8888:
                return 4;
        }
    }
}
