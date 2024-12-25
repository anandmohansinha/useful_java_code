package org.java.example.create;

import java.util.concurrent.Callable;

public class CallableThread {

    public static void main(String[] args) {
        Callable<Integer> c = new Callable() {
            @Override
            public Object call() throws Exception {
                return 5;
            }
        };

        Thread th = new Thread(() ->{
            try {
             int number =  c.call();
                System.out.println("Thread is returning: "+ number);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        th.start();
    }
}
