package com.tapas.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tapas.componentlib.router.Router;
import com.tapas.componentlib.router.ui.UIRouter;
import com.tapas.componentservice.LoginServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openLoginActivity(null);
    }


    //获取其他模块的Fragment(其他class同理)
    public Fragment getLoginFragment() {
        Router router = Router.getInstance();
        if (router.getService(LoginServer.class.getSimpleName()) != null) {
            LoginServer server = (LoginServer) router.getService(LoginServer.class.getSimpleName());
            return server.getLoginFragment();
        }

        return null;
    }


    //跳转其它模块的Activity
    public void openLoginActivity(Bundle bundle) {
       boolean open =  UIRouter.getInstance().openUri(this, "tapas://login", bundle);
    }
}
