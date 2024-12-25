package org.java.example;

import org.java.example.synchronization.BasicSynchronization;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BasicSynchronization obj = new BasicSynchronization();
        try {
            obj.process1();
            obj.process2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println( "Final count" + obj.getCount() );
    }
}
