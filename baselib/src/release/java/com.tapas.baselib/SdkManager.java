package com.tapas.baselib;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * 创建人：luying
 * 创建时间：2017/12/27
 * 类说明：
 */

public class SdkManager {
    public static void initStetho(Context context) {
    }

    public static OkHttpClient.Builder initInterceptor(OkHttpClient.Builder builder) {
        return builder;
    }
}
