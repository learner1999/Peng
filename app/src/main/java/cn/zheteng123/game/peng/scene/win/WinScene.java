package cn.zheteng123.game.peng.scene.win;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import cn.zheteng123.game.peng.GameView;
import cn.zheteng123.game.peng.common.Scene;

public class WinScene extends Scene {

    private WinText mWinText;

    public WinScene(GameView gameView) {
        super(gameView);
    }

    @Override
    public void draw(Canvas canvas, Context context) {

        if (mWinText == null) {
            mWinText = new WinText();
        }
        mWinText.drawSelf(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_UP:
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            default:
        }
        return true;
    }
}
