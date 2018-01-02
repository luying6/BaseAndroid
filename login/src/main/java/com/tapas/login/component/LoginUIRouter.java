package com.tapas.login.component;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.tapas.componentlib.router.ui.IComponentRouter;
import com.tapas.login.LoginActivity;

/**
 * 创建人：luying
 * 创建时间：2018/1/2
 * 类说明：
 */

public class LoginUIRouter implements IComponentRouter {
    public static final String SCHME = "tapas";
    private static final String LOGINHOST = "login";  //LoginActivity的host，如果有其他的Activity也同样需要注册
    private static String[] HOSTS = new String[]{LOGINHOST};
    private static LoginUIRouter loginUIRouter = new LoginUIRouter();

    public static LoginUIRouter getInstance() {
        return loginUIRouter;
    }


    @Override
    public boolean openUri(Context context, String url, Bundle bundle) {
        if (TextUtils.isEmpty(url) || context == null) {
            return true;
        }
        return openUri(context, Uri.parse(url), bundle);
    }

    @Override
    public boolean openUri(Context context, Uri uri, Bundle bundle) {
        if (uri == null || context == null) {
            return true;
        }
        String host = uri.getHost();
        if (LOGINHOST.equals(host)){
            Intent intent = new Intent(context, LoginActivity.class);
            intent.putExtras(bundle == null ? new Bundle() : bundle);
            context.startActivity(intent);
            return true;
        }
            return false;
    }

    @Override
    public boolean openUri(Context context, String url, Bundle bundle, Integer requestCode) {
        return false;
    }

    @Override
    public boolean openUri(Context context, Uri uri, Bundle bundle, Integer requestCode) {
        return false;
    }

    @Override
    public boolean isUri(Uri uri) {
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (SCHME.equals(scheme)) {
            for (String str : HOSTS){
                if (str.equals(host)){
                    return true;
                }
            }
        }
        return false;
    }
}
