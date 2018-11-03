package cn.zheteng123.game.peng.scene.main.spirit;

import android.content.Context;

import cn.zheteng123.game.peng.R;
import cn.zheteng123.game.peng.common.Spirit;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Block extends Spirit {

    private static final String TAG = "Block";

    private static final int WIDTH = 150;

    private static final int HEIGHT = 50;

    public Block(Context context, int left, int top) {
        super(context);

        // init position
        mLeft = left;
        mTop = top;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    protected int getDrawableResource() {
        return R.drawable.block;
    }
}
