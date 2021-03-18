package com.tzh.studydemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.lang.reflect.Field;

public class DisplayUtil {

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue
     * @param scale   （DisplayMetrics类中属性density）
     * @return
     */
    public static int px2dip(float pxValue, float scale) {
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue
     * @param scale    （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(float dipValue, float scale) {
        return (int) (dipValue * scale + 0.5f);
    }

    public static int dipToPixels(Context context, float dip) {
        if (context == null) {
            return 0;
        }
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip,
                r.getDisplayMetrics());
        return (int) px;
    }

    public static int spToPixels(Context context, int sp) {
        if (context == null) {
            return 0;
        }
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                r.getDisplayMetrics());
        return (int) px;
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param fontScale （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(float pxValue, float fontScale) {
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param fontScale （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(float spValue, float fontScale) {
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 根据图片宽高获取等比例的宽度
     *
     * @param nowWidth
     * @param bmpWidth
     * @param bmpHeight
     */
    public static int getReSizeHeight(int nowWidth, int bmpWidth, int bmpHeight) {
        return (int) (nowWidth * (bmpHeight * 1.0 / bmpWidth));
    }

    public static int getReSizeWidth(int nowHeight, int bmpWidth, int bmpHeight) {
        return (int) (nowHeight * (bmpWidth * 1.0 / bmpHeight));
    }

    /*
     * 隐藏键盘
     */
    public static void hideSolftInput(Context context, View v) {
        if (v == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    // 打开虚拟键盘
    public static void openSoftInput(Context context, View v) {
        if (v == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
        imm.showSoftInput(v, 0);
        // imm.showSoftInputFromInputMethod(v.getWindowToken(), 0);
    }

    /**
     * 解决重新设置背景导致padding失效问题
     *
     * @param view  需要重新设置背景的view
     * @param resid 背景资源id
     */
    public static void setBackgroundKeepPadding(View view, int resid) {
        int bottom = view.getPaddingBottom();
        int top = view.getPaddingTop();
        int right = view.getPaddingRight();
        int left = view.getPaddingLeft();
        view.setBackgroundResource(resid);
        view.setPadding(left, top, right, bottom);
    }

    public static void setBackgroundColorKeepPadding(View view, int color) {
        int bottom = view.getPaddingBottom();
        int top = view.getPaddingTop();
        int right = view.getPaddingRight();
        int left = view.getPaddingLeft();
        view.setBackgroundColor(color);
        view.setPadding(left, top, right, bottom);
    }

    /**
     * 解决重新设置背景导致padding失效问题
     *
     * @param view     需要重新设置背景的view
     * @param drawable 背景图片
     */
    @SuppressLint("NewApi")
    public static void setBackgroundKeepPadding(View view, Drawable drawable) {
        int bottom = view.getPaddingBottom();
        int top = view.getPaddingTop();
        int right = view.getPaddingRight();
        int left = view.getPaddingLeft();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
        view.setPadding(left, top, right, bottom);
    }

    /**
     * 获取.9图的padding值
     *
     * @param context
     * @param drawalbeId
     * @return
     */
    public static Rect getNinePatchPading(Context context, int drawalbeId) {
        Rect rect = new Rect();
        Drawable drawable = context.getResources().getDrawable(drawalbeId);
        if (drawable instanceof NinePatchDrawable) {
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
            ninePatchDrawable.getPadding(rect);
        }
        return rect;

    }


    /**
     * 文字的高，不包括上下留白
     *
     * @param fontSize
     * @return
     */
    public static float getFontHeightOnlyText(float fontSize) {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    /**
     * 对喜欢 回复 删除 分享按钮进行调整
     *
     * @param size
     * @param top
     * @param textView
     */
    public static void adjustLeftDrawable(int size, int top, TextView textView) {
        Drawable drawable = textView.getCompoundDrawables()[0];
        drawable.setBounds(0, top, size, top + size);
        textView.setCompoundDrawables(drawable, null, null, null);
    }


    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        if (statusBarHeight == 0) {
            try {
                Class<?> c = Class.forName("com.android.internal.R$dimen");
                Object o = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = (Integer) field.get(o);
                statusBarHeight = context.getResources().getDimensionPixelSize(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return statusBarHeight;
    }

    /**
     * 说明：获取屏幕的宽度
     *
     * @return
     */
    public static int screenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度 包含底部虚拟按键高度
     */
    public static int getRealScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getRealMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 获取屏幕高度 不包含底部虚拟按键高度
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    public static void showView(View... view) {
        if (view != null) {
            for (View value : view) {
                if (value != null) value.setVisibility(View.VISIBLE);
            }
        }
    }

    public static void hideView(View... view) {
        if (view != null) {
            for (View value : view) {
                if (value != null) value.setVisibility(View.GONE);
            }
        }
    }
}