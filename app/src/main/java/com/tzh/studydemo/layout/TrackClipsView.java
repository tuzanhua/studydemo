package com.tzh.studydemo.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.tzh.studydemo.DisplayUtil;
import com.tzh.studydemo.R;
import com.tzh.studydemo.ScreenUtils;

import java.util.List;

public class TrackClipsView extends ViewGroup {

    private static final String TAG = TrackClipsView.class.getName();

    private Context mContext;
    private ConstraintLayout coverLayout;
    private LinearLayout frameLayout;
    private int imageWidth;

    private float startX;
    private int maxScrollWidth;
    private int minScrollWidth;

    public TrackClipsView(Context context) {
        super(context);
        onInitialize(context);
    }

    public TrackClipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitialize(context);
    }

    public TrackClipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInitialize(context);
    }

    public TrackClipsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        onInitialize(context);
    }

    private void onInitialize(Context context) {
        removeAllViews();
        mContext = context;
        //该属性定义了ViewGroup是否将裁剪它的子View
        setClipToPadding(false);
        imageWidth = ScreenUtils.getScreenWidth(mContext) / 8;

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        coverLayout = (ConstraintLayout) LayoutInflater.from(context).inflate(R.layout.layout_video_cover, null);
        addView(coverLayout, params);

        frameLayout = new LinearLayout(context);//图片列表
        frameLayout.setOrientation(LinearLayout.HORIZONTAL);
        frameLayout.setGravity(Gravity.CENTER_VERTICAL);
        frameLayout.setBackgroundColor(Color.BLUE);
        addView(frameLayout);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取总宽度,是包含padding值
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        coverLayout.measure(coverLayout.getMeasuredWidth(), coverLayout.getMeasuredHeight());
        frameLayout.measure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), DisplayUtil.dipToPixels(mContext, 50));
        setMeasuredDimension(width + getPaddingLeft() + getPaddingRight() + MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), height);

        //滑动到设置的StartScreen位置
        //scrollTo(0, mStartScreen * mHeight);
        minScrollWidth = ScreenUtils.getScreenWidth(mContext) / 2 - getMeasuredWidth(); //初始位置（屏幕中心）减去ViewEditProgressView的宽度
        maxScrollWidth = ScreenUtils.getScreenWidth(mContext) / 2;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int coverLeft = ((getMeasuredWidth() / 2 - coverLayout.getMeasuredWidth()) / 3) * 2;
        int top = 100;
        coverLayout.layout(coverLeft, top, coverLeft + coverLayout.getMeasuredWidth(), top + coverLayout.getMeasuredHeight());
        frameLayout.layout(getMeasuredWidth() / 2, top, getMeasuredWidth() / 2 + frameLayout.getMeasuredWidth(), top + DisplayUtil.dipToPixels(mContext, 50));
    }

    //添加视频处理关键帧图片
    public void addImageView(List<Bitmap> bitmaps) {
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            frameLayout.setLayoutParams(layoutParams);
            for (Bitmap bitmap : bitmaps) {
                ImageView imageView = new ImageView(mContext);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(imageWidth, DisplayUtil.dipToPixels(mContext, 50));
                imageView.setLayoutParams(params);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(bitmap);
                frameLayout.addView(imageView);
            }
            invalidate();
        }
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        super.onTouchEvent(event);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                //1.按下记录坐标
//                startX = event.getX();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                //2.记录结束值
//                float endX = event.getX();
//                //3.计算偏移量
//                float distanceX = endX - startX;
//                float toX = getX() + distanceX;
//                if (toX < minScrollWidth) {
//                    toX = minScrollWidth;
//                }
//                if (toX > maxScrollWidth) {
//                    toX = maxScrollWidth;
//                }
//                setX(toX);
////                currentTime = (long) (totalTime * (screenWidth / 2 - getX()) / getMeasuredWidth());
////                Log.e(TAG, "currentTime: " + currentTime);
////                if (playStateListener != null) {
////                    playStateListener.videoProgressUpdate(currentTime, false);
////                }
//                break;
//        }
//
//        return true;
//    }

}
