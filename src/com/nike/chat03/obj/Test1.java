package com.nike.chat03.obj;

public class Test1 {
    public static void main(String[] args){
        try {
            String str = new String();
            str.wait(); //抛出IllegalMonitorStateException 因为无锁 调用wait()方法
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
