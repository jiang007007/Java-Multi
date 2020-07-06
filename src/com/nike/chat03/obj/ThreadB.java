package com.nike.chat03.obj;

public class ThreadB extends Thread {
    private Object obj;
    public ThreadB(Object obj){
        this.obj =obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            System.out.println("开始 notify time =" + System.currentTimeMillis());
            obj.notify();
            System.out.println("结束 notify time=" + System.currentTimeMillis());
        }
    }
}
