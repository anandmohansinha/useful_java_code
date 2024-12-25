package org.java.example.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindPrimeNumber {
    /**
     * Find all the prime numbers in the list using parallel streams.
     */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 10, 17, 20, 29, 35, 40, 50, 67, 71, 89);
        // List<Integer> li = list.parallelStream().filter(FindPrimeNumber::isPrime).collect(Collectors.toList());
       for(Integer num : list ){
         double num1 =   Math.sqrt(num);
           System.out.println(num1);
       }


    }

    /*
    static Integer isPrime(Integer number) {
        if (number <= 1) return false;

    }*/
}
