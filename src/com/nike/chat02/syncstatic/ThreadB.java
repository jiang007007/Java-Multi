package com.nike.chat02.syncstatic;

public class ThreadB extends Thread {
    private Serice serice;
    public ThreadB(Serice serice){
        this.serice =serice;
    }

    @Override
    public void run() {
        serice.printB();
    }
}
