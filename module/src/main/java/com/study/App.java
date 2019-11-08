package com.study;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(System.currentTimeMillis() + ": app main has execute");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Account account = new Account();
                    account.operation();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}

