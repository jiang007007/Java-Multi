package com.nike.chat02;

public class TestOtherSync {
    private static final String A ="A";
    private static final String B ="B";

     public void one() throws InterruptedException {
        synchronized (this){
            System.out.println("one method run");
            Thread.sleep(5000);

            System.out.println("one method end");
        }
    }


     public void two() throws InterruptedException {
        synchronized (this){
            System.out.println("two method run");
            Thread.sleep(5000);
            System.out.println("two method end");
        }
    }

    public static void main(String[] args) {
        TestOtherSync otherSync = new TestOtherSync();
        new OtherThread1(otherSync).start();
        new OtherThread2(otherSync).start();
    }
}
class OtherThread1 extends Thread{
    private TestOtherSync otherSync;
    public OtherThread1(TestOtherSync otherSync){
        this.otherSync = otherSync;
    }

    @Override
    public void run() {
        try {
            otherSync.one();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class OtherThread2 extends Thread{
    private TestOtherSync otherSync;
    public OtherThread2(TestOtherSync otherSync){
        this.otherSync =otherSync;
    }

    @Override
    public void run() {
        try {
            otherSync.two();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

