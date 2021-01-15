package com.dw.boot.uml2;

public class Gravida extends Female implements BirthBaby {

    private int hasChild;

    @Override
    public void birthBaby() {
        System.out.println("生小孩");
    }

}
