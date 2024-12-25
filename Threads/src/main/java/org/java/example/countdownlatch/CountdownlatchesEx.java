package org.java.example.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountdownlatchesEx {

    static CountDownLatch cl = new CountDownLatch(3);
    public void threadTask(String threadName){

        System.out.println(threadName +" collecting the data");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cl.countDown();
    }
    public static void main(String[] args) {
        CountdownlatchesEx ex = new CountdownlatchesEx();
        for(int i=0;i<10;i++) {
            Thread t1 = new Thread(() ->{
                ex.threadTask(Thread.currentThread().getName());
            });
            t1.start();
        }
        try {
            cl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Upload all data");
    }
}
