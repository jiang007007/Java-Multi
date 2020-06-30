package com.nike.chat02;

public class CRThead extends Thread {


    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
