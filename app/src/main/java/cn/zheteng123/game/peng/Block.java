package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Block {
    private static final String TAG = "Block";

    private int mLeft;

    private int mTop;

    private int mWidth = 150;

    private int mHeight = 50;

    private Drawable mDrawable;

    private boolean isShow = true;

    public Block(Context context) {
        // init position
        mLeft = 500;
        mTop = 500;

        mDrawable = context.getResources().getDrawable(R.drawable.block);
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

    public boolean isShow() {
        return isShow;
    }

    public void show() {
        isShow = true;
    }

    public void hide() {
        isShow = false;
    }
    public void drawSelf(Canvas canvas) {
        if (!isShow) {
            return;
        }

        Rect bounds = new Rect(mLeft, mTop, mLeft + mWidth, mTop + mHeight);

        mDrawable.setBounds(bounds);
        mDrawable.draw(canvas);
    }

    public Rect getBounds() {
        return new Rect(mLeft, mTop, mLeft + mWidth, mTop + mHeight);
    }
}
