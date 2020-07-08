package com.nike.chat03.pip;

/**
 * 交替打印
 *    实心三角形 5次
 *    空心三角形 5次
 *
 */
public class DBTools {
        private volatile boolean preIsA = false;
        private static final int COUNT = 5;
        public synchronized void backupA(){
            try {
                while (preIsA){
                    wait();
                }

                for (int i =0; i < COUNT;i++){
                    System.out.println("☆☆☆☆☆");
                }
                preIsA =true;
                //换新所有等待的线程
                notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        public synchronized void backupB(){
            try {
                while (!preIsA){
                    wait();
                }
                for (int i = 0; i < COUNT; i++) {
                    System.out.println("★★★★★");
                }
                preIsA= false;
                notifyAll();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

}
