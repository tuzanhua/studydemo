package com.tzh.android.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.tzh.studydemo.R;

public class ZJButton extends AppCompatButton {

    private Drawable drawable;

    public ZJButton(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public ZJButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ZJButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        drawable = createDrawable(context.getResources().getColor(R.color.colorAccent), 50);
        setBackground(drawable);

//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Bitmap bitmap = null;
//                try {
//                    bitmap = Glide.with(context)
//                            .load(R.drawable.login_bg)
//                            .asBitmap()
//                            .into(720, 1281)
//                            .get();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Log.e("tzh11", bitmap.getAllocationByteCount() + "");
//            }
//        }).start();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_4444;  //565= 4151520
                                                            //8=   8303040
                                                            //8888= 8303040
                                                            //4444 = 8303040
        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.login_bg,options);
        Log.e("tzh", b.getAllocationByteCount()  + "");

//        Glide.with(context)
//                .load(R.drawable.login_bg)
//                .asBitmap()
//                .into(new SimpleTarget<Bitmap>() {
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                        Log.e("tzh222", resource.getAllocationByteCount()+ "");
//                    }
//                });
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setRadius(int radius) {

    }

    public Drawable createDrawable(@ColorInt int argb, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setCornerRadius(radius);
        return gradientDrawable;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

    }
}
