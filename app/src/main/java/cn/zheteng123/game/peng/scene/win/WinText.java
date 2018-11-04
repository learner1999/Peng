package cn.zheteng123.game.peng.scene.win;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import cn.zheteng123.game.peng.common.ControlBlock;

public class WinText extends ControlBlock {

    private Paint mPaint;

    public WinText() {
        mPaint = new Paint();
    }

    @Override
    protected int getWidth() {
        return 400;
    }

    @Override
    protected int getHeight() {
        return 250;
    }

    public void drawSelf(Canvas canvas) {
        if (!isShow) {
            return;
        }

        mLeft = (canvas.getWidth() - getWidth()) / 2;
        mTop = (canvas.getHeight() - getHeight()) / 2;

        Rect bounds = new Rect(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(100);
        Rect rectText = new Rect();
        String text = "你胜利了";
        mPaint.getTextBounds(text, 0, text.length(), rectText);
        Rect rectDrawText = getCenterPos(bounds, rectText);
        canvas.drawText(text, rectDrawText.left, rectDrawText.bottom, mPaint);
    }

}
