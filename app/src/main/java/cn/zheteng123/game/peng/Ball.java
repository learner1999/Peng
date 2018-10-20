package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Ball {

    private static final String TAG = "Ball";

    private int mLeft;

    private int mTop;

    public static final int WIDTH = 40;

    public static final int HEIGHT = 40;

    private Drawable mDrawable;

    private int mSpeedX = -20;

    private int mSpeedY = -20;

    public Ball(Context context, int left, int top) {
        // init position
        mLeft = left;
        mTop = top;

        mDrawable = context.getResources().getDrawable(R.drawable.ball);

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

    public boolean isCollide(Rect rect) {
        return !(mLeft > rect.right || mLeft + WIDTH < rect.left || mTop > rect.bottom || mTop + HEIGHT < rect.top);
    }

    public void drawSelf(Canvas canvas) {
        Rect paddleBounds = new Rect(mLeft, mTop, mLeft + WIDTH, mTop + HEIGHT);

        mDrawable.setBounds(paddleBounds);
        mDrawable.draw(canvas);
    }

    public void reverseY() {
        mSpeedY = -mSpeedY;
    }
}
