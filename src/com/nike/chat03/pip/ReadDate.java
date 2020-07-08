package com.nike.chat03.pip;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadDate {

    public void ReadDate(PipedInputStream ins){
        try {
            System.out.println("read: ");
            byte[] bytedate= new byte[20];
            int len=0;
            while ((len = ins.read(bytedate)) !=-1){
                String result= new String(bytedate,0,len);
                System.out.print(result);
            }
            System.out.println();
            ins.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
