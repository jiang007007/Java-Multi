package com.nike.chat02;

public class MyObjectThreadA extends Thread{
    private MyObject myObject;
    public MyObjectThreadA(MyObject myObject){
        this.myObject = myObject;
    }

    @Override
    public void run() {
        //同步方法
        myObject.methodA();
    }
}
