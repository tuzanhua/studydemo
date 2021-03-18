package com.tzh.studydemo.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class ViewPager3 extends LinearLayout {

    float lastX = 0f;
    float lastY = 0f;
    int scrollPointId = 0;
    private float translationY;
    int dy = 0;
    private int height;

    public ViewPager3(Context context) {
        super(context);
    }

    public ViewPager3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPager3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        Log.e("tzh","height :" + height);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        Log.e("tzh", "onTouch : " + event.toString());
        int actionMasked = event.getActionMasked();
        int actionIndex = event.getActionIndex();

        switch (actionMasked) {

            case MotionEvent.ACTION_DOWN:
                scrollPointId = event.getPointerId(0);
                lastX = event.getX();
                lastY = event.getY();
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                scrollPointId = event.getPointerId(actionIndex);
                lastX = event.getX(actionIndex);
                lastY = event.getY(actionIndex);
                break;
            case MotionEvent.ACTION_MOVE:
                int pointerIndex = event.findPointerIndex(scrollPointId);
                int x = (int) (event.getX(pointerIndex) + 0.5);
                int y = (int) (event.getY(pointerIndex) + 0.5);

                dy = dy + (int) (lastY - y);
                Log.e("tzh", "dy : " + dy);
                lastY = y;
                if (Math.abs(dy) >= height){
                    return true;
                }
                break;

            case MotionEvent.ACTION_POINTER_UP:
                final int actionIndex1 = event.getActionIndex();
                if (event.getPointerId(actionIndex1) == scrollPointId) {
                    // Pick a new pointer to pick up the slack.
                    final int newIndex = actionIndex == 0 ? 1 : 0;
                    scrollPointId = event.getPointerId(newIndex);
                    lastX = (int) (event.getX(newIndex) + 0.5f);
                    lastY = (int) (event.getY(newIndex) + 0.5f);
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("tzh", "ACTION_UP");
                lastY = 0;
                dy = 0;
                break;
        }

        return super.dispatchTouchEvent(event);
    }
}
