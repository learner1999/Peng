package cn.zheteng123.game.peng.scene.main.spirit;

import android.content.Context;
import android.graphics.Rect;

import cn.zheteng123.game.peng.GameView;
import cn.zheteng123.game.peng.R;
import cn.zheteng123.game.peng.common.Spirit;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ball extends Spirit {

    private static final String TAG = "Ball";

    public static final int WIDTH = 40;

    public static final int HEIGHT = 40;

    private int mSpeedX = -20;

    private int mSpeedY = -20;

    public Ball(Context context, int left, int top) {
        super(context);

        // init position
        mLeft = left;
        mTop = top;
    }

    public void move() {
        mLeft += mSpeedX;
        mTop += mSpeedY;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    protected int getDrawableResource() {
        return R.drawable.ball;
    }

    public void reverseY() {
        mSpeedY = -mSpeedY;
    }

    public void reverseX() {
        mSpeedX = -mSpeedX;
    }
}
