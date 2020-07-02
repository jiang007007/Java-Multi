package com.nike.chat02;

public class Task {
    synchronized public void otherMethod(){
        System.out.println("---------------------------------------------- otherMethod");
    }

    synchronized public void doLongTimeTask(){
        synchronized (this){
            for (int i = 0; i < 10000; i++) {
                System.out.println("Synchronized threadName="
                +Thread.currentThread().getName() + ", i =" + (i+1));
            }
        }
    }
}
