package cn.zheteng123.game.peng.scene.main.spirit;

import android.content.Context;
import android.graphics.Canvas;

import cn.zheteng123.game.peng.R;
import cn.zheteng123.game.peng.common.Spirit;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/13
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Paddle extends Spirit {

    private static final String TAG = "Paddle";

    private static final int WIDTH = 200;

    private static final int HEIGHT = 45;

    public Paddle(Canvas canvas, Context context) {
        super(context);

        // init position
        mLeft = canvas.getWidth() / 2 - WIDTH / 2;
        mTop = canvas.getHeight() - HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    @Override
    protected int getDrawableResource() {
        return R.drawable.paddle;
    }

    public void moveX(int x) {
        mLeft += x;
    }
}
