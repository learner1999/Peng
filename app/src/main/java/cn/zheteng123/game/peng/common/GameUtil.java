package cn.zheteng123.game.peng.common;

import android.graphics.Rect;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/12/8
 *     desc   : 工具类
 *     version: 1.0
 * </pre>
 */
public class GameUtil {

    public static boolean isInRect(Rect rect, float x, float y) {
        return x >= rect.left && x <= rect.right && y >= rect.top && y <= rect.bottom;
    }
}
