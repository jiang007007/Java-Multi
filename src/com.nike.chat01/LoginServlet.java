package com.nike.chat01;

public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;
    public static void doPost(String username,String password){
        try {
            usernameRef = username;
//            passwordRef = password;

            if (usernameRef.equalsIgnoreCase("a")){
                Thread.sleep(5000);
            }
            passwordRef =password;
            System.out.println("username =" + usernameRef +" password="  + passwordRef);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ALogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

class BLogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}