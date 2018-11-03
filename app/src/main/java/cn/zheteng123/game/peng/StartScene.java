package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

public class StartScene extends Scene {

    private StartControlBlock mStartControlBlock;

    public StartScene(GameView gameView) {
        super(gameView);
    }

    @Override
    public void draw(Canvas canvas, Context context) {
        if (mStartControlBlock == null) {
            mStartControlBlock = new StartControlBlock();
        }
        mStartControlBlock.drawSelf(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_UP:
                if (isInRect(mStartControlBlock.getBounds(), event.getX(), event.getY())) {
                    // 跳转到主场景
                    mGameView.jumpToMainScene();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            default:
        }
        return true;
    }

    private boolean isInRect(Rect rect, float x, float y) {
        return x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom;
    }
}
