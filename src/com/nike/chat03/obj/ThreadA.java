package com.nike.chat03.obj;

public class ThreadA extends Thread {

    private Object obj;
    public ThreadA(Object obj){
        this.obj =obj;
    }

    @Override
    public void run() {
       try {
           synchronized (obj){
               System.out.println("开始 wait time=" + System.currentTimeMillis());
               obj.wait();
               System.out.println("结束 wait time =" + System.currentTimeMillis());
           }
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
