package com.nike.chat02;

public class PublicVar {
    private String userName ="A";
    private String password="AA";

    synchronized public void setValue(String userName,String password){
        try {
            this.userName= userName;
            Thread.sleep(5000);
            this.password =password;
            System.out.println("setValue method thread name="
            +Thread.currentThread().getName() + " username="+ userName+ " password=" + password);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void getValue(){
        System.out.println("getValue method thread name="
                +Thread.currentThread().getName() + " username=" + userName + " password=" + password);
    }
}
