package com.nike.chat02;

public class ThreadB extends Thread {
    private HasSelfPrivateNum privateNum;
    public ThreadB(HasSelfPrivateNum privateNum){
        this.privateNum = privateNum;
    }

    @Override
    public void run() {
        privateNum.addI("b");
    }
}
