package com.tzh.studydemo.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

import androidx.annotation.Nullable;

import com.tzh.studydemo.DisplayUtil;

import java.util.List;

public class TrackContainer extends HorizontalScrollView {

    private Context mContext;
    private TrackClipsView mTrackView;
    private Paint cursorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float cursorSize = 0f; //中间竖线指示器宽度

    public TrackContainer(Context context) {
        super(context);
        onInitialize(context);
    }

    public TrackContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitialize(context);
    }

    public TrackContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInitialize(context);
    }



    private void onInitialize(Context context) {
        mContext = context;
        cursorSize = DisplayUtil.dipToPixels(context, 2f);
        cursorPaint.setColor(Color.BLACK);

        mTrackView = new TrackClipsView(context);
        addView(mTrackView);

        if (getChildCount() > 1) {
            throw new RuntimeException("TrackContainer not support multi child view.");
        }

        if (getChildCount() == 1 && !(getChildAt(0) instanceof TrackClipsView)) {
            throw new RuntimeException("TrackContainer`s child view must be TrackView.");
        }
    }

    private TrackClipsView getChildView() {
        return mTrackView;
    }

    /**
     * 绘制中间竖线指示器
     *
     * @param canvas
     */
    @Override
    protected void dispatchDraw(@Nullable Canvas canvas) {
        super.dispatchDraw(canvas);
        if (canvas != null) {
            canvas.drawRoundRect(
                    getScrollX() + (getMeasuredWidth() - cursorSize) / 2,
                    50f,
                    getScrollX() + (getMeasuredWidth() + cursorSize) / 2,
                    (float) getMeasuredHeight() - 50f,
                    cursorSize / 2.0F,
                    cursorSize / 2.0F,
                    cursorPaint);
        }
    }

    public void addImageView(List<Bitmap> bitmaps) {
        if (bitmaps != null) {
            mTrackView.addImageView(bitmaps);
        }
    }

    /**
     * 当布局文件加载完成的时候回调这个方法
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}
