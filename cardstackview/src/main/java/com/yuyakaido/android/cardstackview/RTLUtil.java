package com.yuyakaido.android.cardstackview;

import android.util.LayoutDirection;

import java.util.Locale;

import androidx.core.text.TextUtilsCompat;

/**
 * @author 李栋杰
 * @time 2019/7/2  17:27
 * @desc RTL相关工具类
 */
public class RTLUtil {

    /**
     * 是否处于RTL模式
     * @return
     */
    public static boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == LayoutDirection.RTL;
    }

}
