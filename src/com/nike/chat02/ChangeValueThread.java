package com.nike.chat02;

public class ChangeValueThread extends Thread {
    private PublicVar publicVar;
    public ChangeValueThread(PublicVar publicVar){
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        publicVar.setValue("B","BB");
    }
}

