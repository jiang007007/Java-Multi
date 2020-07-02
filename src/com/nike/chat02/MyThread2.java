package com.nike.chat02;

public class MyThread2 extends Thread {

    private MyList myList;
    public MyThread2(MyList myList){
        this.myList = myList;
    }

    @Override
    public void run() {
        MyService myService = new MyService();
        myService.addServiceMethod(myList,"B");
    }
}
