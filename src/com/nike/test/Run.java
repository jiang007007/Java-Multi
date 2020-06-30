package com.nike.test;

import com.nike.chat02.*;

public class Run {
    public static void main(String[] args) {
         CR();
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
}
