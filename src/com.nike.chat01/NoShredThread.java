package com.nike.chat01;



/**
 * 不共享实例变量不会有线程安全的问题
 */
public class NoShredThread extends Thread {
    private int count =5;

    public NoShredThread(String threadName){
        this.setName(threadName);
    }

    @Override
    public void run() {
        while (count >0){
            count--;
            System.out.println("由" + this.currentThread().getName()
            +"计算， count=" + count);
        }
    }
}

/**
 * 在调用类中创建一个Thread 对象  传入不同线程  导致变量共享
 *   count--;
 *   1 取出原有count的值
 *   2 计算count-1;
 *   3 对i进行赋值
 */
class ShreadThread extends Thread{
    private int count =5;

    @Override
    public void run() {
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算， count =" + count);
    }
}
class ThreadTest{
    public static void main(String[] args) {

    }
}
