package com.tapas.baselib.base;

import android.app.Application;

import com.tapas.baselib.BuildConfig;
import com.tapas.baselib.SdkManager;
import com.tapas.baselib.util.TapasUtil;

/**
 * 创建人：luying
 * 创建时间：2017/12/28
 * 类说明：
 */

public class BaseApplication extends Application{
    private static BaseApplication sInstance;

    public static BaseApplication getsInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        TapasUtil.init(this);
        if (BuildConfig.DEBUG){
            SdkManager.initStetho(this);
        }
    }
}
