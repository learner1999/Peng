package cn.zheteng123.game.peng.scene.gameover;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import cn.zheteng123.game.peng.common.ControlBlock;

public class AgainControlBlock extends ControlBlock {
    private Paint mPaint;

    public AgainControlBlock() {
        mPaint = new Paint();
    }

    @Override
    protected int getWidth() {
        return 300;
    }

    @Override
    protected int getHeight() {
        return 150;
    }

    public void drawSelf(Canvas canvas) {
        if (!isShow) {
            return;
        }

        mLeft = (canvas.getWidth() - getWidth()) / 2;
        mTop = (canvas.getHeight() - getHeight()) / 2 + 300;

        Rect bounds = new Rect(mLeft, mTop, mLeft + getWidth(), mTop + getHeight());
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(bounds, mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(50);
        Rect rectText = new Rect();
        mPaint.getTextBounds("重新开始", 0, 4, rectText);
        Rect rectDrawText = getCenterPos(bounds, rectText);
        canvas.drawText("重新开始", rectDrawText.left, rectDrawText.bottom, mPaint);
    }
}
