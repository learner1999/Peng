package cn.zheteng123.game.peng;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import cn.zheteng123.game.peng.common.Scene;
import cn.zheteng123.game.peng.scene.gameover.GameOverScene;
import cn.zheteng123.game.peng.scene.main.MainScene;
import cn.zheteng123.game.peng.scene.start.StartScene;
import cn.zheteng123.game.peng.scene.win.WinScene;


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

    // 帧率
    private int mFps = 60;

    // 是否处于暂停状态
    private boolean mPause;

    private Scene mScene = new StartScene(this);

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_CANVAS:
                    if (!mPause) {
                        invalidate();
                        mHandler.sendEmptyMessageDelayed(REFRESH_CANVAS, 1000 / mFps);
                    }
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

        mScene.draw(canvas, getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mScene.onTouchEvent(event);
    }

    private void init(Context context) {
        startMainLoop();
    }

    /**
     * 跳转到主场景
     */
    public void jumpToMainScene() {
        mScene = new MainScene(this);
    }

    /**
     * 跳转到游戏结束场景
     */
    public void jumpToGameOverScene() {
        mScene = new GameOverScene(this);
    }

    /**
     * 跳转到通关场景
     */
    public void jumpWinScene() {
        mScene = new WinScene(this);
    }

    /**
     * 暂停或继续游戏
     */
    public void changePauseState() {
        mPause = !mPause;
        if (!mPause) {
            startMainLoop();
        }
    }

    /**
     * 开始游戏绘制
     */
    public void startMainLoop() {
        mHandler.sendEmptyMessageDelayed(REFRESH_CANVAS, 1000 / mFps);
    }

    /**
     * 刷新游戏画面
     */
    public void refresh() {
        invalidate();
    }

    /**
     * 是否处于暂停状态
     * @return 是否暂停
     */
    public boolean isPause() {
        return mPause;
    }
}
