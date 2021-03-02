package com.example.framework.u.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import com.example.framework.BuildConfig;

public class SystemUI {

public static void fixUI(Activity mActivity){
    //onCreate 是一个activity
    // 二进制计数 && |
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
       mActivity.getWindow().getDecorView()
                .setSystemUiVisibility(
                       View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
 //       mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
}
}
