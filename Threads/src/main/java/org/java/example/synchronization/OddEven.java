package org.java.example.synchronization;

public class OddEven {

    private Object lock = new Object();
    private boolean oddTurn = true;
    public void print(){ // created seprate method for thread creation
        Thread t1 = new Thread(() ->{
            try {
                printEven();  // assign critical task
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();

        Thread t2 = new Thread(() ->{
            try {
                printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();
    }

    /**
     * how to use wait and notify
     * Thread1 has to print at that time thread2 will wait
     * Then thread1 notify and thread2 has to print and vice versa so both thread has to wait and notify
     */
    /*
    private void printEven() throws InterruptedException {
        for(int i=2; i<=10; i +=2){
            wait(); // this is not correct there must be some condition to invoke notify() and we have to use
            // synchorized keyword also so that nobody distrube current working thread.
            System.out.println(i);
            notify();
        }
    }*/

    private void printEven() throws InterruptedException {
        // so that nobody distrub unless i explicitly want it
        synchronized (lock){
            for(int i=2; i<=10; i +=2){
                // now we have to apply one condition that when wait will run
                while(oddTurn){ // if oddTurn true then we have to wait, otherwise do ur work and notify
                    lock.wait();// why not only wait();
                }
                System.out.println("Even: "+ i);
                oddTurn = true;
                lock.notify();
            }
        }
    }

    private void printOdd() throws InterruptedException {
        synchronized (lock) {

            for(int i=1; i<=10; i +=2){ // after each number print we have to wait
                while(!oddTurn) {
                    lock.wait();
                }
                System.out.println("Odd : "+ i);
                oddTurn = false;
                lock.notify();
            }
        }

    }

    public static void main(String[] args) {
        OddEven obj = new OddEven();
            obj.print();
    }
}
