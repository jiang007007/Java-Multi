package com.nike.chat03.mylist;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程间的通信
 *   1  使用sleep()结合while(true) 死循环来实现多个线程间通信。
 */
public class MyList {
    private List<String> list = new ArrayList<>();

    public void add(){
        list.add("蒋杰");
    }

    public int size(){
        return list.size();
    }
}
