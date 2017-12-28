package com.tapas.baselib.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * 创建人：luying
 * 创建时间：2017/12/28
 * 类说明：
 */

public class TapasUtil {
    //全局的所以直接用静态
    private static Context context;

    public TapasUtil() {
    }


    /**
     * 初始化Context 在application中调用
     * @param context
     */
    public static void init(Context context){
        TapasUtil.context = context.getApplicationContext();
    }


    public static Context getContext(){
        if (context != null) return context;
        throw new NullPointerException("TapasUtil没有初始化");
    }



    public static boolean isAppDebug() {
        if (TextUtils.isEmpty(context.getPackageName())) return false;
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(context.getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }




}
