package com.enigma.java_stream_xa.logic;

import java.util.Arrays;

/**
 * This class demonstrates two methods for summing an array of integers.
 */
public class ArraySum {
    public void reduce (Integer[] numbers) {
        // 1. Sum array of int values using for loop
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("Sum using for loop: " + sum);

        // 2. Sum array of int values using stream reduce
        Integer reduce = Arrays.stream(numbers).reduce(0, Integer::sum);
        System.out.println("Sum using stream reduce: " + reduce);
    }
}
