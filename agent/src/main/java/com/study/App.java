package com.study;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Account account = new Account();
                    account.operation();
                }
            }
        });
        thread.start();
    }
}
class Account{
    public void operation(){
        System.out.println("operation...");
    }
}
