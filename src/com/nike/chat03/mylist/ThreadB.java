package com.nike.chat03.mylist;

/**
 * 线程B  判断MyList中实力域中元素的大小是否为5  =>线程b停止
 */
public class ThreadB  extends Thread{
    private int i;
    private MyList myList;
    public ThreadB(MyList myList){
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            while (myList.size() != 5){
            }
            System.out.println("list.size == 5了，线程B要退出了！");
            throw new InterruptedException();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
