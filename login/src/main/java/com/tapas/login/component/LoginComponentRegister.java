package com.tapas.login.component;

import android.util.Log;

import com.tapas.componentlib.component.IComponentRegister;
import com.tapas.componentlib.router.ui.UIRouter;

/**
 * 创建人：luying
 * 创建时间：2018/1/2
 * 类说明：Login对外注册组件
 */

public class LoginComponentRegister implements IComponentRegister{
//    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();
    LoginUIRouter loginUIRouter = LoginUIRouter.getInstance();

    public LoginComponentRegister() {
    }

    @Override
    public void onCreate() {
//        router.addService(LoginServer.class.getName(), new LoginServerImpl());
        uiRouter.registerUI(loginUIRouter);
        Log.i("2222222","11111");
    }

    @Override
    public void onStop() {
//        router.removeService(LoginServer.class.getName());
        uiRouter.unregisterUI(loginUIRouter);
    }
}
