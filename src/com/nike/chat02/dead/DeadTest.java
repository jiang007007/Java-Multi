package com.nike.chat02.dead;

public class DeadTest implements Runnable {
    private String flags;
    private Object obj1= new Object();
    private Object obj2= new Object();

    public void setFlags(String flags){
        this.flags =flags;
    }
    @Override
    public void run() {
        if (flags.equals("a")){
            synchronized (obj1){
                try {
                    System.out.println("flags=" + flags);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj2){
                    System.out.println("加锁顺序 obj1 -> obj2");
                }
            }
        }else if (flags.equals("b")){
            synchronized (obj2){
                try {
                    System.out.println("flags=" + flags);
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (obj1){
                    System.out.println("加锁顺序 obj2 ->obj1");
                }
            }
        }

    }
}
