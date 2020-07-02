package com.nike.chat02.service;

import com.nike.chat02.MyObject;

/**
 * x  不是this对象   做为"对象监视器"
 * 多线程同时执行synchronized(x){} 同步代码块时呈同步效果
 */
public class Service {
    public void testMethod1(MyObject object){
        synchronized (object){
            try {
                System.out.println("testMethod1___getLock time=" + System.currentTimeMillis() + " run ThreadName="
                +Thread.currentThread().getName());
                Thread.sleep(2000);

                System.out.println("testMethod1 releaseLock time=" +System.currentTimeMillis()+ " run ThreadName="
                + Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
