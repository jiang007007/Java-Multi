package com.nike.chat02;

public class MyObjectThreadB extends Thread {
    private MyObject myObject;
    public MyObjectThreadB(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        myObject.methodB();
    }
}
