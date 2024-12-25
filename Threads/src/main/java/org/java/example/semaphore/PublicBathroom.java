package org.java.example.semaphore;

import java.util.concurrent.Semaphore;

public class PublicBathroom {

    Semaphore sm = new Semaphore(3);

    public static void main(String[] args) {
        for(int i=0;i<10;i++){


        }
        Thread th = new Thread(()->{
            System.out.println("inside bathroom");
        });
    }


}
