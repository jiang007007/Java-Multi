package com.nike.chat03.obj;

import com.nike.chat03.mylist.MyList;

public class Test2 {
    public static void main(String[] args) {
        method2();
    }

    private static void method(){
        try {
            String lock = new String("");
            System.out.println("syn 上面的代码");
            synchronized (lock){
                System.out.println("syn 第一行");
                //  lock.wait();  //在这等待  需要另一个线程持有相同的所 唤醒当前线程   notify or wait(time)
                lock.wait(5000,1000);
                System.out.println("wait 下的代码");
            }
            System.out.println("syn 下面的代码");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    /**
     * 当两个线程只有同一把锁时
     *   线程A 进入wait 释放锁 线程B只有当前锁执行notify唤醒A线程
     *   注意：
     *      当线程notify要释放锁之后  才会线程A执行
     *      使用于生产者和消费者
     *
     */

    private static void method1(){
        Object lock = new Object();

        ThreadA threadA = new ThreadA(lock);
        threadA.start();

        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }

    private static void method2(){
        String lock = "";
        P p = new P(lock);
        C c = new C(lock);
        new Thread(()->{
            while (true){
                p.setValue();
            }
        }).start();
        new Thread(()->{
            while (true){
                c.getValue();
            }
        }).start();
    }
}
