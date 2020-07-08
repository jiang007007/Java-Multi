package com.nike.chat03.test;

import com.nike.chat03.mylist.MyList;
import com.nike.chat03.mylist.ThreadA;
import com.nike.chat03.mylist.ThreadB;
import com.nike.chat03.pip.ReadDate;
import com.nike.chat03.pip.WriteDate;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
            method2();
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

    private static void method2() throws IOException, InterruptedException {
        WriteDate writeDate = new WriteDate();
        ReadDate readDate = new ReadDate();
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        //pipedInputStream.connect(pipedOutputStream);
        //判断pipedInputStream 连接当前的pipedOutStream  不能重复连接
        pipedOutputStream.connect(pipedInputStream);

        //当管道中没有数据 则会阻塞等待数据  =>阻塞同步IO
        new Thread(()->readDate.ReadDate(pipedInputStream)).start();

        Thread.sleep(2000);

        new Thread(()-> writeDate.writeDate(pipedOutputStream)).start();
    }
}
