package com.tapas.componentlib.router.ui;

/**
 * 创建人：luying
 * 创建时间：2017/12/25
 * 类说明：
 */

public interface IUIRouter extends IComponentRouter{
    /**
     * 添加优先级
     */
    int PRIORITY_NORMAL = 0;
    int PRIORITY_LOW = -1000;
    int PRIORITY_HEIGHT = 1000;

    void registerUI(IComponentRouter router, int priority);

    void registerUI(IComponentRouter router);

    void registerUI(String host);

    void registerUI(String host, int priority);

    void unregisterUI(IComponentRouter router);

    void unregisterUI(String host);

}
