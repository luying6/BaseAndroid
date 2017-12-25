package com.tapas.componentlib.router;

import android.text.TextUtils;

import com.tapas.componentlib.component.IComponentRegister;

import java.util.HashMap;

/**
 * 创建人：luying
 * 创建时间：2017/12/22
 * 类说明：
 */

public class Router {
    private HashMap<String, Object> services = new HashMap<>();

    private static HashMap<String, IComponentRegister> components = new HashMap<>();

    private static volatile Router instance;

    public Router() {
    }

    public static Router getInstance() {
        if (instance == null) {
            synchronized (Router.class) {
                if (instance == null) {
                    instance = new Router();
                }
            }
        }
        return instance;
    }


    public synchronized void addService(String serviceName, Object serviceImpl) {
        if (serviceName == null || serviceImpl == null) {
            return;
        }

        services.put(serviceName, serviceImpl);
    }

    public synchronized Object getService(String serviceName) {
        if (serviceName == null) {
            return null;
        }
        return services.get(serviceName);
    }

    public synchronized void removeService(String serviceName) {
        if (serviceName == null) {
            return;
        }
        services.remove(serviceName);
    }


    public static void reisterComponent(String className) {
        if (TextUtils.isEmpty(className)) {
            return;
        }

        if (components.keySet().contains(className)) {
            return;
        }
        try {
            Class clazz = Class.forName(className);
            IComponentRegister componentRegister = (IComponentRegister) clazz.newInstance();
            componentRegister.onCreate();
            components.put(className, componentRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unRegisterComponent(String classname) {
        if (TextUtils.isEmpty(classname)) {
            return;
        }
        if (components.keySet().contains(classname)) {
            components.get(classname).onStop();
            components.remove(classname);
            return;
        }

        try {
            Class clazz = Class.forName(classname);
            IComponentRegister componentRegister = (IComponentRegister) clazz.newInstance();
            componentRegister.onStop();
            components.remove(classname);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
