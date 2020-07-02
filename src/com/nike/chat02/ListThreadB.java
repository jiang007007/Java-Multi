package com.nike.chat02;

public class ListThreadB extends Thread {
    private MyList myList;
    public ListThreadB(MyList myList){
        this.myList = myList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            myList.add("threadB" + (i+1));
        }
    }
}
