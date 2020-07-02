package com.nike.chat02;

public class SyncSThread2 extends Thread {
    private Task task;
    public SyncSThread2(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        task.otherMethod();
    }
}
