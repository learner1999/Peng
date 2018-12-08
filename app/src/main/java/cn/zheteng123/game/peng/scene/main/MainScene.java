package cn.zheteng123.game.peng.scene.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import cn.zheteng123.game.peng.GameView;
import cn.zheteng123.game.peng.LevelInfo;
import cn.zheteng123.game.peng.common.GameUtil;
import cn.zheteng123.game.peng.common.Scene;
import cn.zheteng123.game.peng.scene.main.spirit.Ball;
import cn.zheteng123.game.peng.scene.main.spirit.Block;
import cn.zheteng123.game.peng.scene.main.spirit.Paddle;
import cn.zheteng123.game.peng.scene.main.spirit.PauseControlBlock;

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

    private PauseControlBlock mPauseControlBlock;

    private Rect mRectCanvas;

    private boolean mIsFire;

    private float mTouchX;

    /**
     * 当前关卡
     */
    private int mCurLevel = 1;

    public MainScene(GameView gameView) {
        super(gameView);

        mIsFire = false;
        mRectCanvas = new Rect();
    }

    @Override
    public void draw(Canvas canvas, Context context) {

        // 是否通关
        if (mCurLevel > LevelInfo.levels.length - 1) {
            mGameView.jumpWinScene();
            return;
        }

        if (mPaddle == null) {
            mPaddle = new Paddle(canvas, context);
        }
        mPaddle.drawSelf(canvas);

        if (mBlockList == null) {
            mBlockList = new ArrayList<>();

            LevelInfo.Level level = LevelInfo.levels[mCurLevel];
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
            mBall.move();
            if (mBall.getLeft() < mRectCanvas.left || mBall.getLeft() + mBall.getWidth() > mRectCanvas.right) {
                mBall.reverseX();
            }
            if (mBall.getTop() < mRectCanvas.top) {
                mBall.reverseY();
            }
            if (mBall.getTop() + mBall.getHeight() > mRectCanvas.bottom) {
                mGameView.jumpToGameOverScene();
                return;
            }

            // collide with paddle, change direction
            if (mBall.isCollide(mPaddle.getBounds())) {
                mBall.reverseY();
            }
        }
        mBall.drawSelf(canvas);

        // collide with block, change direction
        for (Block block : mBlockList) {
            if (block.isShow() && mBall.isCollide(block.getBounds())) {
                block.hide();
                mBall.reverseY();
            }
        }

        // 判断砖块是否消灭完毕，进入下一关
        boolean isAllBlockDestroyed = true;
        for (Block block : mBlockList) {
            if (block.isShow()) {
                isAllBlockDestroyed = false;
                break;
            }
        }
        if (isAllBlockDestroyed) {
            mCurLevel += 1;

            // 将 mBlockList 置为 null，使其走砖块初始化流程，这块逻辑需要优化
            mBlockList = null;
        }

        // 暂停按钮
        if (mPauseControlBlock == null) {
            mPauseControlBlock = new PauseControlBlock();
        }
        mPauseControlBlock.drawSelf(canvas);
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

                // 点击暂停按钮
                if (GameUtil.isInRect(mPauseControlBlock.getBounds(), event.getX(), event.getY())) {
                    // 游戏暂停或继续
                    mGameView.changePauseState();
                }
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
