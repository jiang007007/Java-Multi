package com.nike.chat02.syncstatic;

public class ThreadD extends Thread {
    private Serice serice;
    public ThreadD(Serice serice){
        this.serice = serice;
    }

    @Override
    public void run() {
        serice.printD();
    }
}
