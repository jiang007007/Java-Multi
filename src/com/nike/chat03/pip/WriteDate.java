package com.nike.chat03.pip;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

public class WriteDate {
    //向管道写入数据
    public void writeDate(PipedOutputStream out){
        try {
            System.out.println("ThreadName ="+ Thread.currentThread().getName());
            for (int i = 0; i < 300; i++) {
                String outDate=""+ (i+1);
                out.write(outDate.getBytes(StandardCharsets.UTF_8));
                System.out.print(outDate);
            }
            System.out.println();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
