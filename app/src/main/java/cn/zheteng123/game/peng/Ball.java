package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Rect;

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

    public void move(Rect rectCanvas, Rect rectPaddle) {
        mLeft += mSpeedX;
        mTop += mSpeedY;
        if (mLeft < rectCanvas.left || mLeft + WIDTH > rectCanvas.right) {
            mSpeedX = -mSpeedX;
        }
        if (mTop < rectCanvas.top || mTop + HEIGHT > rectCanvas.bottom) {
            mSpeedY = -mSpeedY;
        }

        // collide with paddle, change direction
        if (isCollide(rectPaddle)) {
            mSpeedY = -mSpeedY;
        }
    }

    @Override
    protected int getWidth() {
        return WIDTH;
    }

    @Override
    protected int getHeight() {
        return HEIGHT;
    }

    @Override
    protected int getDrawableResource() {
        return R.drawable.ball;
    }

    public void reverseY() {
        mSpeedY = -mSpeedY;
    }
}
