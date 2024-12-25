package org.java.example.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    Semaphore sm = new Semaphore(3);

    public void threadTask(String threadName){
        try {
            sm.acquire(); // once u accquire semaphore key , you have to release it so that waiting thread can use it
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+" is using this bathroom");


        try {
            Thread.sleep(4000);// three thread parallely come and take the bathroom key, when 4th one come it has to wait
            sm.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        SemaphoreExample se = new SemaphoreExample();
        for (int i =0 ;i<5 ;i++){
            // how can we pass thread name while crearting thread
            Thread t = new Thread(()->{
               se.threadTask(Thread.currentThread().getName());
            });
            t.start();
        }
    }
}
