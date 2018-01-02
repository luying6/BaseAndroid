package com.tapas.base;

import com.tapas.baselib.base.BaseApplication;
import com.tapas.componentlib.router.Router;

/**
 * 创建人：luying
 * 创建时间：2018/1/2
 * 类说明：
 */

public class Tapas extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();

    }

    private void initRouter() {
        //反射加载组件，也可以放在需要使用的地方进行加载
        Router.reisterComponent("com.tapas.login.component.LoginComponentRegister");
    }
}
