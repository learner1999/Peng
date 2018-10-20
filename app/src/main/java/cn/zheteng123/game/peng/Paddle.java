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
public class Paddle {

    private static final String TAG = "Paddle";

    private int mLeft;

    private int mTop;

    private int mWidth = 200;

    private int mHeight = 45;

    private Drawable mDrawable;

    public Paddle(Canvas canvas, Context context) {
        // init position
        mLeft = canvas.getWidth() / 2 - mWidth / 2;
        mTop = canvas.getHeight() - mHeight;

        mDrawable = context.getResources().getDrawable(R.drawable.paddle);

    }

    public int getLeft() {
        return mLeft;
    }

    public int getTop() {
        return mTop;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public void moveX(int x) {
        mLeft += x;
    }

    public void drawSelf(Canvas canvas) {
        Rect paddleBounds = new Rect(mLeft, mTop, mLeft + mWidth, mTop + mHeight);

        mDrawable.setBounds(paddleBounds);
        mDrawable.draw(canvas);
    }

    public Rect getBounds() {
        return new Rect(mLeft, mTop, mLeft + mWidth, mTop + mHeight);
    }
}
