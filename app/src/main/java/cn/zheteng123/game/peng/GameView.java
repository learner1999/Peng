package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class GameView extends View {

    private static final String TAG = "GameView";

    private static final int REFRESH_CANVAS = 1;

    private float mTouchX;
    private boolean mIsFire;

    private Paddle mPaddle;
    private Ball mBall;
    private Block mBlock;

    private Rect mRectCanvas;
    private Rect mRectPaddle;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_CANVAS:
                    invalidate();
                    mHandler.sendEmptyMessageDelayed(REFRESH_CANVAS, 1000 / 60);
                    break;
                default:
            }
        }
    };

    public GameView(Context context) {
        super(context);
        init(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // draw paddle
        if (mPaddle == null) {
            mPaddle = new Paddle(canvas, getContext());
        }
        mPaddle.drawSelf(canvas);

        // draw block
        if (mBlock == null) {
            mBlock = new Block(getContext());
        }
        mBlock.drawSelf(canvas);

        // draw ball
        if (mBall == null) {
            int ballLeft = getWidth() / 2 - Ball.WIDTH / 2;
            int ballTop = mPaddle.getTop() - Ball.HEIGHT;
            mBall = new Ball(getContext(), ballLeft, ballTop);
        }
        if (mIsFire) {
            canvas.getClipBounds(mRectCanvas);
            mBall.move(mRectCanvas, mPaddle.getBounds());
        }
        mBall.drawSelf(canvas);

        // collide with block, change direction
        if (mBlock.isShow() && mBall.isCollide(mBlock.getBounds())) {
            mBlock.hide();
            mBall.reverseY();
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

    private void init(Context context) {
        mHandler.sendEmptyMessageDelayed(REFRESH_CANVAS, 1000 / 30);

        mIsFire = false;
        mRectCanvas = new Rect();
    }
}
