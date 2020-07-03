package com.nike.chat02.volati;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类 具有原子性
 *   但是方法和方法之间的调用不是原子性的
 */
public class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("count=" + count.incrementAndGet());
        }
    }
}
