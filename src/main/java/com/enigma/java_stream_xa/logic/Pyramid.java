package com.enigma.java_stream_xa.logic;

import java.util.stream.IntStream;

/**
 * A utility class for generating and printing pyramids made of asterisks (*) using Java Stream API.
 */
public class Pyramid {
    /**
     * Prints a pyramid made of asterisks (*) with the specified height.
     *
     * @param n The height of the pyramid to be printed.
     */
    public void printPyramid(int n, char symbol) {
        IntStream.range(0, n)
            .forEach(i -> {
                // Printing spaces
                IntStream.range(0, n - i - 1)
                        .forEach(j -> System.out.print(" "));
                // Printing symbol
                IntStream.range(0, i + 1)
                        .forEach(j -> System.out.printf("%c ", symbol));
                // Ending line after each row
                System.out.println();
            });
    }
}
