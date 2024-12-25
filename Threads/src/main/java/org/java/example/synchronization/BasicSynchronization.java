package org.java.example.synchronization;

import java.util.stream.IntStream;

public class BasicSynchronization {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void process1() throws InterruptedException {
        Thread th1 = new Thread(() ->{
            IntStream.range(0,100).forEach(i -> count++);
            System.out.println("Thread 1: "+ count);
        });
        th1.start();
        th1.join();
    }

    public void process2() throws InterruptedException{
        Thread th1 = new Thread(() ->{
            IntStream.range(0,100).forEach(i -> count++);
            System.out.println("Thread 2: "+ count);
        });
        th1.start();
        th1.join();
    }
}
