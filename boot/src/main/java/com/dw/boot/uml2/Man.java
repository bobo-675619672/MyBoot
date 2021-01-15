package com.dw.boot.uml2;

/**
 * 人
 */
public class Man {

    private Head head;

    private int hand;

    private int foot;

    public void run(int speed) {
        System.out.println("人跑步");
    }

    public void take(int num) {
        System.out.println("人拿东西");
    }

}
