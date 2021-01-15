package com.dw.boot.uml1.u_extend;

import com.dw.boot.uml1.base.Person;

public class Teacher extends Person {

    private String teacherNo;

    public void teach() {
        System.out.println("教学");
    }

}
