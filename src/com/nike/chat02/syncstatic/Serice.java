package com.nike.chat02.syncstatic;

/**
 * 在静态方法中加synchronized 锁的是.*java文件的Class对象
 * 在非静态方法中加synchronized 锁  是对象
 *
 * 开启三个线程，两个线程方法静态方法  一个线程访问非静态方法
 *    输出结果：
 *      同时能运行一个静态方法  一个非静态方法,静态方法同步结束访问另一个静态方法
 *          => 静态方法 同步  锁的 不是同一个对象
 */
public class Serice {
    synchronized public static void printA(){
        //ACC_SYNCHRONIZED。 ACC_STATIC   静态方法和非静态代码中在flags中增加了ACC_SYNCHRONIZED
        try {
            System.out.println("ThreadName=" + Thread.currentThread().getName()+"在" + System.currentTimeMillis()
            +"进入printA()");
            Thread.sleep(3000);
            System.out.println("ThreadName=" + Thread.currentThread().getName()+ "在" + System.currentTimeMillis()
            + "离开printA()");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public static void printB(){
        System.out.println("ThreadName= " + Thread.currentThread().getName() + "在" + System.currentTimeMillis()
           + "进入printB()");
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "在 " + System.currentTimeMillis()
         + "离开printB()");
    }

    synchronized public void printC(){
        //ACC_SYNCHRONIZED
        System.out.println("ThreadName= " +Thread.currentThread().getName() + "在" + System.currentTimeMillis()
           + "进入printC()");
        System.out.println("ThreadName=" + Thread.currentThread().getName() + "在" + System.currentTimeMillis()
          + "离开printC()");
    }


    public static void printD(){
        synchronized (Serice.class){
            System.out.println("ThreadName= " + Thread.currentThread().getName()+ "在" + System.currentTimeMillis()
            + "进入printD()");
            System.out.println("ThreadName= "  + Thread.currentThread().getName() + "在" +System.currentTimeMillis()
             + "离开了printD()");
        }
    }
}
