package com.tapas.baselib.util;

import android.content.Context;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.tapas.baselib.Constant;
import com.tapas.baselib.SdkManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建人：luying
 * 创建时间：2017/12/27
 * 类说明：
 */

public class RetrofitFactory {
    private volatile static Retrofit retrofit;
//    private static final Interceptor cacheControlInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
////            if (!NetWorkUtil.isNetworkConnected())
//            return null;
//        }
//    }

    //这个context用全局的
    public static Retrofit getRetrofit(final Context context) {
        Interceptor cacheControlInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetWorkUtil.isNetworkConnected(context)) {
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                }

                Response originalResponse = chain.proceed(request);
                if (NetWorkUtil.isNetworkConnected(context)) {
                    // 有网络时 设置缓存为默认值
                    String cacheControl = request.cacheControl().toString();
                    return originalResponse.newBuilder()
                            .header("Cache-Control", cacheControl)
                            .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时 设置超时为1周
                    int maxStale = 60 * 60 * 24 * 7;
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
            }
        };




        if (retrofit == null) {
            synchronized (Retrofit.class) {
                if (retrofit == null) {
                    Cache cache = new Cache(new File(context.getCacheDir(), "TapasHttpCache"), 1024 * 1024 * 50);
                    //cookie持久化
                    ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .cookieJar(cookieJar)
                            .cache(cache)
                            .addInterceptor(cacheControlInterceptor)
                            .connectTimeout(10, TimeUnit.SECONDS)
                            .readTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(15, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true);
                    if (!Constant.ENV_PRD){
                        builder = SdkManager.initInterceptor(builder);
                    }
                    retrofit = new Retrofit.Builder()
                            .baseUrl(Constant.BASE_URL)
                            .client(builder.build())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
