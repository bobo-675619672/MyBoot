package com.dw.boot.uml2;

import java.util.List;

/**
 * 男人
 */
public class Male extends Man {

    // 胡须
    private int beard;
    // 喉结
    private int glottis;

    private List<Work> work;

    public void run() {
        // 男人走路70速度
        super.run(70);
    }

    /**
     * 赚钱
     */
    public void earnMoney() {
        System.out.println("赚钱");
    }

}
