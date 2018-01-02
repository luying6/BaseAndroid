package com.tapas.login.component;

import android.app.Fragment;

import com.tapas.componentservice.LoginServer;

/**
 * 创建人：luying
 * 创建时间：2018/1/2
 * 类说明：
 */

public class LoginServerImpl implements LoginServer{
    @Override
    public Fragment getLoginFragment() {
        return new Fragment();
    }
}
