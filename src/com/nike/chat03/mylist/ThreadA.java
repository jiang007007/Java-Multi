package com.nike.chat03.mylist;

/**
 * 线程A 向MyList中的实例变量添加元素
 */
public class ThreadA extends Thread {

    private MyList myList;
    public ThreadA(MyList myList){
        this.myList=myList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                myList.add();
                System.out.println("添加了" + (i+1)+ "个元素");
                ThreadB.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
