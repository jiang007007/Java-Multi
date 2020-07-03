package com.nike.chat03.test;

import com.nike.chat03.mylist.MyList;
import com.nike.chat03.mylist.ThreadA;
import com.nike.chat03.mylist.ThreadB;

public class Test {
    public static void main(String[] args) {
            method();
    }

    private static void method(){
        MyList myList = new MyList();
        ThreadA t1 = new ThreadA(myList);
        t1.setName("A");
        t1.start();

        ThreadB t2 = new ThreadB(myList);
        t2.setName("B");
        t2.start();
    }
}
