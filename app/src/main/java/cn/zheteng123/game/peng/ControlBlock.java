package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/28
 *     desc   : 控制按钮
 *     version: 1.0
 * </pre>
 */
public abstract class ControlBlock {

    protected int mLeft;

    protected int mTop;

    protected boolean isShow = true;

    /**
     * 获取宽度
     * @return 宽度
     */
    protected abstract int getWidth();

    /**
     * 获取高度
     * @return 高度
     */
    protected abstract int getHeight();

    public void show() {
        isShow = true;
    }

    public void hide() {
        isShow = false;
    }

    public Rect getBounds() {
        return new Rect(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());
    }
}
