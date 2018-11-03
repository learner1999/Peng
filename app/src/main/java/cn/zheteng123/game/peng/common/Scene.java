package cn.zheteng123.game.peng.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import cn.zheteng123.game.peng.GameView;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/11/03
 *     desc   : 场景
 *     version: 1.0
 * </pre>
 */
public abstract class Scene {

    protected GameView mGameView;

    public Scene(GameView gameView) {
        mGameView = gameView;
    }

    public abstract void draw(Canvas canvas, Context context);

    public abstract boolean onTouchEvent(MotionEvent event);
}
