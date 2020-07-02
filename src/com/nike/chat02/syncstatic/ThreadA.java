package com.nike.chat02.syncstatic;

public class ThreadA extends Thread {
    private Serice serice;
    public ThreadA(Serice serice){
        this.serice =serice;
    }
    @Override
    public void run() {
        serice.printA();
    }
}
