package cn.zheteng123.game.peng;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : learner1999
 *     e-mail : roadoflearning@live.com
 *     time   : 2018/10/28
 *     desc   : 暂时用于保存关卡信息，后续使用 json 或 xml 格式存储
 *     version: 1.0
 * </pre>
 */
public class LevelInfo {

    private static final int LEVEL_NUM = 2;

    public static Level[] levels;

    static {
        // 为了方便，数组长度加 1
        levels = new Level[LEVEL_NUM + 1];

        // 第一关
        Level level1 = new Level();
        level1.blocks.add(new Pos(200, 200));
        level1.blocks.add(new Pos(500, 500));
        levels[1] = level1;

        // 第二关
        Level level2 = new Level();
        level2.blocks.add(new Pos(200, 200));
        level2.blocks.add(new Pos(500, 200));
        levels[2] = level2;
    }

    static class Level {
        List<Pos> blocks = new ArrayList<>();
    }

    static class Pos {
        int left;
        int top;

        Pos(int left, int top) {
            this.left = left;
            this.top = top;
        }
    }
}
