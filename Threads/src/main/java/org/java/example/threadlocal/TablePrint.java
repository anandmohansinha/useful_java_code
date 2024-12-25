package org.java.example.threadlocal;

public class TablePrint {

    static ThreadLocal<Integer> tl = new ThreadLocal();
    // create task which is perform by thread
    public void printTable(Integer number, String threadName) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Table for "+ number);
        for(int i=1 ;i<=10;i++){

            System.out.println(threadName+" : "+number*i);

        }
    }

    public static void main(String[] args) {
        TablePrint tp = new TablePrint();

        Thread t1 = new Thread(()->{
            tl.set(5);
            tp.printTable(tl.get(), Thread.currentThread().getName());
        });
        t1.start();
        Thread t2 = new Thread(()->{
            tl.set(10);
            tp.printTable(tl.get(), Thread.currentThread().getName());
        });
        t2.start();
    }
}
