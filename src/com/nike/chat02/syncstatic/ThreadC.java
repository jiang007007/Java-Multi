package com.nike.chat02.syncstatic;

public class ThreadC extends Thread {
    private Serice serice;
    public ThreadC(Serice serice){
        this.serice =serice;
    }

    @Override
    public void run() {
        serice.printC();
    }
}
