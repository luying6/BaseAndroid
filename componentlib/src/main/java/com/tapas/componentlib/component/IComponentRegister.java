package com.tapas.componentlib.component;

/**
 * 创建人：luying
 * 创建时间：2017/12/22
 * 类说明：注册组件/卸载抽象类
 */

public interface IComponentRegister {
    void onCreate();
    void onStop();
}
