package com.huizhi.box.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

/**
 * Created by admin on 2018/4/26.
 */

public class StatusBarCompat {
    private static final int INVALID_VAL = -1;
    private static final int COLOR_DEFAULT = Color.parseColor("#20000000");

  //  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public static void compat(Activity activity, int statusColor)
//    {
//
//        //当前手机版本为5.0及以上
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//        {
//            if (statusColor != INVALID_VAL)
//            {
//                activity.getWindow().setStatusBarColor(statusColor);
//            }
//            return;
//        }
//
//        //当前手机版本为4.4
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
//        {
//            int color = COLOR_DEFAULT;
//            ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
//            if (statusColor != INVALID_VAL)
//            {
//                color = statusColor;
//            }
//            View statusBarView = new View(activity);
//            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                    getStatusBarHeight(activity));
//            statusBarView.setBackgroundColor(color);
//            contentView.addView(statusBarView, lp);
//        }
//
//    }
    public static void compat(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StatusBarLollipop.setStatusBarColor(activity, statusColor);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarKitKat.setStatusBarColor(activity, statusColor);
        }
    }
    public static void compat(Activity activity)
    {
        compat(activity, INVALID_VAL);
    }


    public static int getStatusBarHeight(Context context)
    {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
