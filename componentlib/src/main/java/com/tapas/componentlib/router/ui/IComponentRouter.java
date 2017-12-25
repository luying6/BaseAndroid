package com.tapas.componentlib.router.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/**
 * 创建人：luying
 * 创建时间：2017/12/25
 * 类说明：打开activity
 */

public interface IComponentRouter {
    boolean openUri(Context context, String url, Bundle bundle);
    boolean openUri(Context context, Uri uri, Bundle bundle);
    boolean openUri(Context context, String url, Bundle bundle, Integer requestCode);
    boolean openUri(Context context, Uri uri, Bundle bundle, Integer requestCode);
    boolean isUri(Uri uri);
}
