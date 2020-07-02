package com.nike.chat02;

/**
 * 可能出现脏读
 */
public class MyThread1 extends Thread {
    private MyList myList;
    public MyThread1(MyList myList){
        this.myList = myList;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(myList,"A");
    }
}
