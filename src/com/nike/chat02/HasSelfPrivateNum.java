package com.nike.chat02;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 局部变量木有线程安全的问题
 *  实例变量有可能有
 */
public class HasSelfPrivateNum {
    private int num=0;
    synchronized public void addI(String userName){
        try {
                if (userName.equals("a")){
                    num =100;
                    System.out.println("a set over！");
                    Thread.sleep(2000);//模拟IO等待
                }else {
                    num = 200;
                    System.out.println("b set over!");
                }
                System.out.println(userName + " num=" + num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}


