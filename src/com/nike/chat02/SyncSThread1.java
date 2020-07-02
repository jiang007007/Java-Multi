package com.nike.chat02;

public class SyncSThread1 extends Thread {
    private Task task;
    public SyncSThread1(Task task){
        this.task =task;
    }

    @Override
    public void run() {
        task.doLongTimeTask();
    }
}
