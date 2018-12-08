package cn.zheteng123.game.peng;

import android.app.Application;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/12/8
 *     desc   : 自定义 Application 对象，用于获取全局 Context
 *     version: 1.0
 * </pre>
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LocContext.setContext(this);
    }
}
