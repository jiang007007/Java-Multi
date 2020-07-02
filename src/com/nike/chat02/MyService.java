package com.nike.chat02;

public class MyService {
    //此处不能再方法上添加synchronized  因为在线程A B上 new了对象 =》锁的不是相同对象
     public MyList addServiceMethod(MyList myList,String data){
       try {
           synchronized (myList){
               if (myList.getSize() < 1){
                   //模拟远程花费2秒取数据
                   Thread.sleep(2000);
                   myList.add(data);
               }
           }
       }
       catch (InterruptedException e){
           e.printStackTrace();
       }

       return myList;
    }
}
