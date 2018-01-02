package com.tapas.componentservice;

import android.app.Fragment;

/**
 * 创建人：luying
 * 创建时间：2018/1/2
 * 类说明：Login模块对外提供的Fragment,以及一些其他的类(不包括Activity，Activity有专门的UiRouter)
 */

public interface LoginServer {
    Fragment getLoginFragment();
}
