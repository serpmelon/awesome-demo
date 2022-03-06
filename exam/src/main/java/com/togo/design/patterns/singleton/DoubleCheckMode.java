package com.togo.design.patterns.singleton;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 上午9:32 2022/3/6
 **/
public class DoubleCheckMode {

    private static DoubleCheckMode INSTANCE;

    private DoubleCheckMode() {
    }

    public static DoubleCheckMode getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }

        synchronized (DoubleCheckMode.class) {

            if (INSTANCE != null) {
                return INSTANCE;
            }

            INSTANCE = new DoubleCheckMode();
            return INSTANCE;
        }
    }
}
