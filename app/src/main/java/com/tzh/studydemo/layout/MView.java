package com.tzh.studydemo.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.tzh.studydemo.R;

public class MView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmapMan;
    private Bitmap bitmapEyes;

    public MView(Context context) {
        this(context, null);
    }

    public MView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        bitmapMan = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        bitmapEyes = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);

        //DST
        canvas.drawBitmap(bitmapMan, 0, 0, paint);
        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmapEyes, 0, 0, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);
    }
}
