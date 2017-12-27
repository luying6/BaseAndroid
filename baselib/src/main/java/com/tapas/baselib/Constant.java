package com.tapas.baselib;

/**
 * 创建人：luying
 * 创建时间：2017/12/27
 * 类说明：
 */

public class Constant {
    public static final boolean ENV_PRD = false;
    //    http://120.55.93.189:3003/v2/
    public static final String ONLINE = "https://api.cbnweek.com/v3/";
    public static final String TEST = "http://api.cbnweek.dtcj.com/v3/";
    public static final String BASE_URL = ENV_PRD ? ONLINE: TEST;
}
