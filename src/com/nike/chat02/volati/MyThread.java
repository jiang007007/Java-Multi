package com.nike.chat02.volati;

/**
 * Volatile中保证了可见性  不保证原子性
 *  volatile+synchronized =>原子操作
 */
public class MyThread implements Runnable {

    private static  int count;

    public static synchronized void addCount(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
