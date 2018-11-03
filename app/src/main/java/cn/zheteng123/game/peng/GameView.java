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

    private Scene mScene = new StartScene(this);

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

        mScene.draw(canvas, getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mScene.onTouchEvent(event);
    }

    private void init(Context context) {
        mHandler.sendEmptyMessageDelayed(REFRESH_CANVAS, 1000 / 30);
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
}
