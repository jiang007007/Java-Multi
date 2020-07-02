package com.nike.chat02;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private List<String> list = new ArrayList();
    synchronized public void add(String userName){
        System.out.println("ThreadName=" + Thread.currentThread().getName()+ "执行了add方法！！！");
        list.add(userName);
        System.out.println("ThreadName=" + Thread.currentThread().getName()+ "推出了add方法！！！");
    }


    synchronized public int getSize(){
        System.out.println("ThreadName=" + Thread.currentThread().getName()+ "执行了getSize方法！！！");
        int sizeValue = list.size();
        System.out.println("ThreadName=" + Thread.currentThread().getName()+ "退出了getSize方法！！！");
        return sizeValue;
    }

}
