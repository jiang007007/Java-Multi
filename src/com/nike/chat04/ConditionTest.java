package com.nike.chat04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    //默认非公平锁
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void tryawit(){
        lock.lock();
        try {
            System.out.println("A");
            condition.await();
            System.out.println("B");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
