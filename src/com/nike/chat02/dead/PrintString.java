package com.nike.chat02.dead;

public class PrintString implements Runnable{

    private volatile   boolean isContinuePrint =true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }


    public void printStringMethod(){
        try {
            while (isContinuePrint){
                System.out.println("run printStringMethod threadName="
                +Thread.currentThread().getName());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        printStringMethod();
    }
}
