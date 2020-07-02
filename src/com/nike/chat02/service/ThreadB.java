package com.nike.chat02.service;

import com.nike.chat02.MyObject;

public class ThreadB extends Thread {
    private Service service;
    private MyObject myObject;

    public ThreadB(Service service,MyObject myObject){
        this.service =service;
        this.myObject =myObject;
    }

    @Override
    public void run() {
        service.testMethod1(myObject);
    }
}
