package com.tzh.android.customdrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tzh.studydemo.R;

public class BoarderDrawable extends Drawable {

    Paint paint;

    public BoarderDrawable() {
        paint = new Paint();
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
    }

    /**
     * @param canvas
     * canvas rotate  旋转的是坐标系
     */
    @Override
    public void draw(@NonNull Canvas canvas) {
        paint.setColor(Color.parseColor("#ff0000"));
        canvas.drawLine(0, 300, 500, 300, paint);
        //================
        canvas.save(); // 保存当前matrix 到一个私有的栈上
//        canvas.saveLayer(); // 需要花费巨大的代价  s开启硬件加速来 均衡它所耗费的性能

//        View view = new View();
//        view.setLayerType(View.LAYER_TYPE_HARDWARE,null);
//        view.animate().alpha(1.0f).rotation(0.5f).setDuration(2000).start();

        canvas.rotate(90,250,250);
        paint.setColor(Color.parseColor("#00ff00"));
        canvas.drawLine(0, 300, 500, 300, paint);
//        canvas.restore();

        paint.setColor(Color.BLACK);
        canvas.drawLine(0,0,300,0,paint);
        canvas.restore();

        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,300,0,paint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }
}
