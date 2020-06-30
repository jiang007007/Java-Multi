package com.nike.chat02;

public class ThreadA extends Thread {
    private HasSelfPrivateNum privateNum;
    public ThreadA(HasSelfPrivateNum privateNum){
        this.privateNum =privateNum;
    }

    @Override
    public void run() {
        privateNum.addI("a");
    }
}
