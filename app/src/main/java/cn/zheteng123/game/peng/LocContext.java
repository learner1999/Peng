package cn.zheteng123.game.peng;

import android.content.Context;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/12/8
 *     desc   : 全局 Context
 *     version: 1.0
 * </pre>
 */
public class LocContext {

    private static Context sContext;

    public static void setContext(Context context) {
        sContext = context;
    }

    public static Context getContext() {
        return sContext;
    }
}
