package com.nike.test;

import com.nike.chat02.*;
import com.nike.chat02.dead.DeadTest;
import com.nike.chat02.dead.PrintString;
import com.nike.chat02.syncstatic.Serice;
import com.nike.chat02.syncstatic.ThreadC;
import com.nike.chat02.syncstatic.ThreadD;
import com.nike.chat02.volati.AddCountThread;
import com.nike.chat02.volati.MyThread;
import com.nike.chat04.ConditionTest;

public class Run {
    public static void main(String[] args) throws InterruptedException {
//         syst();
//        myList();【
//        zu();
//            method();
//        method1();
//          deadMethod();
        method5();
    }

    private static void NoSelfThread(){
        HasSelfPrivateNum privateNum = new HasSelfPrivateNum();
        new ThreadA(privateNum).start();
        new ThreadB(privateNum).start();
    }


    private static void syncThreadMethod(){
        /**
         * MyObject  有同步方法 methodA
         *           非同步方法 methodB   异步调用
         *           若 methodB 则顺序调用
         */
        MyObject myObject = new MyObject();
        MyObjectThreadA myObjectThreadA = new MyObjectThreadA(myObject);
        myObjectThreadA.setName("A");
        myObjectThreadA.start();
        MyObjectThreadB myObjectThreadB = new MyObjectThreadB(myObject);
        myObjectThreadB.setName("B");
        myObjectThreadB.start();
    }

    //脏读
    private static void ChangeValue(){
        PublicVar publicVar = new PublicVar();
        ChangeValueThread changeValueThread = new ChangeValueThread(publicVar);
        changeValueThread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publicVar.getValue();
    }


    //synchronized 是可重入的
    public static void CR(){
        CRThead crThead = new CRThead();
        crThead.start();
    }


    //synchronized锁的对象
    public static void syst(){
        Task task = new Task();
        new SyncSThread1(task).start();
        new SyncSThread2(task).start();
    }

    public static void myList(){
        MyList myList = new MyList();

        ListThreadA listThreadA = new ListThreadA(myList);
        listThreadA.setName("A");
        listThreadA.start();

        ListThreadB listThreadB = new ListThreadB(myList);
        listThreadB.setName("B");
        listThreadB.start();
    }


    public static void zu() throws InterruptedException {
        MyList myList = new MyList();
        MyThread1 myThread1 = new MyThread1(myList);
        myThread1.setName("A");
        myThread1.start();

        MyThread2 myThread2 = new MyThread2(myList);
        myThread2.setName("B");
        myThread2.start();

        Thread.sleep(6000);
        //size输出为2  但是在MyService中  getSize<1 才执行add
        System.out.println("listSize=" + myList.getSize());
    }


    private static void method(){
        com.nike.chat02.service.Service service = new com.nike.chat02.service.Service();
        MyObject myObject = new MyObject();

        com.nike.chat02.service.ThreadA threadA = new com.nike.chat02.service.ThreadA(service, myObject);
        threadA.setName("a");
        threadA.start();

        com.nike.chat02.service.ThreadB threadB = new com.nike.chat02.service.ThreadB(service,myObject);
        threadB.setName("b");
        threadB.start();
    }


    private static void method1(){

        Serice serice = new Serice();

        com.nike.chat02.syncstatic.ThreadA threadA = new com.nike.chat02.syncstatic.ThreadA(serice);
        threadA.setName("A");
        threadA.start();

        com.nike.chat02.syncstatic.ThreadB threadB = new com.nike.chat02.syncstatic.ThreadB(serice);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(serice);
        threadC.setName("C");
        threadC.start();


        ThreadD threadD = new ThreadD(serice);
        threadD.setName("D");
        threadD.start();
    }


    public static void deadMethod(){
        DeadTest test = new DeadTest();
        test.setFlags("a");
        new Thread(test).start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.setFlags("b");
        new Thread(test).start();
    }

    public static void method2(){
        PrintString string = new PrintString();
        new Thread(string).start();
        System.out.println("我要停止它！ stopThread ="
        +Thread.currentThread().getName());
        string.setContinuePrint(false);
    }

    public static void method3(){
        MyThread[] myThreads= new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i]= new MyThread();
        }
        for (int i = 0; i < myThreads.length; i++) {
            new Thread(myThreads[i]).start();
        }
    }

    public static void method4(){
        AddCountThread addCountThread = new AddCountThread();
        Thread t1 = new Thread(addCountThread);
        t1.start();

        Thread t2 = new Thread(addCountThread);
        t2.start();

        Thread t3 = new Thread(addCountThread);
        t3.start();

        Thread t4 = new Thread(addCountThread);
        t4.start();

        Thread t5 = new Thread(addCountThread);
        t5.start();
    }

    //进入waiting状态
    private static void method5(){
        ConditionTest test = new ConditionTest();
        new Thread(test::tryawit).start();
        new Thread(test:: tryawit).start();
        new Thread(test:: tryawit).start();
    }
}
