package com.dw.boot.uml2;

import java.util.List;

/**
 * 人类
 */
public class Human {

    private List<Man> mans;

    public void eat(Food food) {
        System.out.println("吃食物");
    }

    public void drink(Water water) {
        System.out.println("喝水");
    }

}
