package com.nike.chat01;

/**
 * 线程的运行具有随机性
 * start的顺序不是运行的顺序 运行是获取CUP时间段  具有不确定性
 * Thread 构造函数 接收一个Runnable  =》可以接收一个Thread对象 多态
 */
public class MyThread extends Thread {
    @Override
    public void run() {
       try {
           for (int i = 0; i <10 ; i++){
                int time = (int) (Math.random() *1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
           }
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
class Run{
    public static void main(String[] args) {
        try {
//            MyThread myThread = new MyThread();
//            myThread.setName("myThread");
//            myThread.start();
            Thread thread = new Thread(new MyThread());
            thread.setName("myThread");
            thread.start();
            for (int i = 0; i < 10; i++) {
                int time =(int)(Math.random() *1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
