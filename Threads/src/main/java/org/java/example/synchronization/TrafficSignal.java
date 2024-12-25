package org.java.example.synchronization;

import java.util.stream.IntStream;

public class TrafficSignal {

    Object lock = new Object();
    private String  currentSignal = "Orange";
    public void allowTraffic(String road) {
        while (true) {
            synchronized (lock){
                while(!currentSignal.equals(road)){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(">>> "+road);
                try {
                    Thread.sleep(2000); // Simulate the green signal duration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                switch (road){
                    case "Orange":
                        currentSignal="Red";
                        break;
                    case "Red":
                        currentSignal="Green";
                        break;
                    case "Green":
                        currentSignal="Orange";
                        break;
                }
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        TrafficSignal ts = new TrafficSignal();
        Thread roadA = new Thread(() -> ts.allowTraffic("Orange"));
        Thread roadB = new Thread(() -> ts.allowTraffic("Red"));
        Thread roadC = new Thread(() -> ts.allowTraffic("Green"));


        roadA.start();
        roadB.start();
        roadC.start();
    }

}
