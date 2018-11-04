package cn.zheteng123.game.peng.scene.gameover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import cn.zheteng123.game.peng.GameView;
import cn.zheteng123.game.peng.common.Scene;

public class GameOverScene extends Scene {

    private GameOverText mGameOverText;

    private AgainControlBlock mAgainControlBlock;

    public GameOverScene(GameView gameView) {
        super(gameView);
    }

    @Override
    public void draw(Canvas canvas, Context context) {

        if (mGameOverText == null) {
            mGameOverText = new GameOverText();
        }
        mGameOverText.drawSelf(canvas);

        if (mAgainControlBlock == null) {
            mAgainControlBlock = new AgainControlBlock();
        }
        mAgainControlBlock.drawSelf(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_UP:
                if (isInRect(mAgainControlBlock.getBounds(), event.getX(), event.getY())) {
                    // 跳转到主场景
                    mGameView.jumpToMainScene();
                    return true;
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
