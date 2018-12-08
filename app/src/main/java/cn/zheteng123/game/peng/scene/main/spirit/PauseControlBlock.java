package cn.zheteng123.game.peng.scene.main.spirit;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import cn.zheteng123.game.peng.LocContext;
import cn.zheteng123.game.peng.R;
import cn.zheteng123.game.peng.common.ControlBlock;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/12/8
 *     desc   : 暂停按钮
 *     version: 1.0
 * </pre>
 */
public class PauseControlBlock extends ControlBlock {

    @Override
    protected int getWidth() {
        return 50;
    }

    @Override
    protected int getHeight() {
        return 50;
    }

    public void drawSelf(Canvas canvas) {
        if (!isShow) {
            return;
        }

        // 放在左上角
        mLeft = 50;
        mTop = 50;

        Rect bounds = new Rect(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());
        Drawable drawable = LocContext.getContext().getResources().getDrawable(R.drawable.pause);
        drawable.setBounds(bounds);
        drawable.draw(canvas);
    }
}
