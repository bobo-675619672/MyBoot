package com.dw.boot.uml2;

/**
 * 小孩
 */
public class Child extends Man implements Cry {

    private int young;

    public void run() {
        // 小孩走路10速度
        super.run(10);
    }

    @Override
    public void cry() {
        System.out.println("小孩哭");
    }

}
