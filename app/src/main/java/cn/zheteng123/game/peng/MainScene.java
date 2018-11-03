package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/11/03
 *     desc   : 主场景
 *     version: 1.0
 * </pre>
 */
public class MainScene extends Scene {

    private Paddle mPaddle;
    private Ball mBall;

    private List<Block> mBlockList;

    private Rect mRectCanvas;

    private boolean mIsFire;

    private float mTouchX;

    public MainScene(GameView gameView) {
        super(gameView);

        mIsFire = false;
        mRectCanvas = new Rect();
    }

    @Override
    public void draw(Canvas canvas, Context context) {
        if (mPaddle == null) {
            mPaddle = new Paddle(canvas, context);
        }
        mPaddle.drawSelf(canvas);

        if (mBlockList == null) {
            mBlockList = new ArrayList<>();

            LevelInfo.Level level = LevelInfo.levels[1];
            List<LevelInfo.Pos> blockPosList = level.blocks;
            for (LevelInfo.Pos pos : blockPosList) {
                mBlockList.add(new Block(context, pos.left, pos.top));
            }
        }
        for (Block block : mBlockList) {
            block.drawSelf(canvas);
        }

        if (mBall == null) {
            int ballLeft = canvas.getWidth() / 2 - Ball.WIDTH / 2;
            int ballTop = mPaddle.getTop() - Ball.HEIGHT;
            mBall = new Ball(context, ballLeft, ballTop);
        }
        if (mIsFire) {
            canvas.getClipBounds(mRectCanvas);
            mBall.move(mRectCanvas, mPaddle.getBounds());
        }
        mBall.drawSelf(canvas);

        // collide with block, change direction
        for (Block block : mBlockList) {
            if (block.isShow() && mBall.isCollide(block.getBounds())) {
                block.hide();
                mBall.reverseY();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mTouchX = event.getX();
                break;

            case MotionEvent.ACTION_UP:
                mTouchX = event.getX();
                mIsFire = true;
                break;

            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                mPaddle.moveX((int) (x - mTouchX));
                mTouchX = event.getX();
                break;

            default:
        }
        return true;
    }
}
