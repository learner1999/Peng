package cn.zheteng123.game.peng.common;

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
public abstract class Spirit {

    protected int mLeft;

    protected int mTop;

    protected Drawable mDrawable;

    protected boolean isShow = true;

    protected Spirit(Context context) {
        mDrawable = context.getResources().getDrawable(getDrawableResource());
    }

    /**
     * 获取宽度
     * @return 宽度
     */
    public abstract int getWidth();

    /**
     * 获取高度
     * @return 高度
     */
    public abstract int getHeight();

    /**
     * 获取图片资源
     * @return 图片资源 ID
     */
    protected abstract int getDrawableResource();

    public boolean isCollide(Rect rect) {
        return !(mLeft > rect.right || mLeft + getWidth() < rect.left || mTop > rect.bottom || mTop + getHeight() < rect.top);
    }

    public void drawSelf(Canvas canvas) {
        if (!isShow) {
            return;
        }

        Rect bounds = new Rect(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());

        mDrawable.setBounds(bounds);
        mDrawable.draw(canvas);
    }

    public void setLeft(int left) {
        mLeft = left;
    }

    public int getLeft() {
        return mLeft;
    }

    public void setTop(int top) {
        mTop = top;
    }

    public int getTop() {
        return mTop;
    }

    public Rect getBounds() {
        return new Rect(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());
    }

    public void show() {
        isShow = true;
    }

    public void hide() {
        isShow = false;
    }

    public boolean isShow() {
        return isShow;
    }
}
