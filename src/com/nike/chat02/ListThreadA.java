package com.nike.chat02;

public class ListThreadA extends Thread {
    private MyList myList;
    public ListThreadA(MyList myList){
        this.myList = myList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            myList.add("threadA" + (i+1));
        }
    }
}
