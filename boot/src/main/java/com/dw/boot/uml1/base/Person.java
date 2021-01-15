package com.dw.boot.uml1.base;

public class Person {

    public String address = "";

    int age = 10;

    private String name = "Bob";

    protected String idNo = "123";

    public String getAddress() {
        return address;
    }

    void addAge() {
        age++;
    }

    private boolean checkName() {
        return true;
    }

    protected boolean checkIdNo() {
        return true;
    }

}
