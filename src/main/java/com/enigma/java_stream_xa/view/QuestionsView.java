package com.enigma.java_stream_xa.view;

import com.enigma.java_stream_xa.logic.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsView {
    private final int COUNT = 50;
    public void solve(){
        sumArrayValuesExample();
        sortExample();
        pyramidExample();
        searchTextExample();
        sortHashMapExample();
    }

    private void sortHashMapExample(){
        System.out.println("Search Text Example");
        System.out.println("=".repeat(COUNT));

        Map<String, String> map = new HashMap<String, String>() {{
            put("Indonesia", "Jakarta");
            put("Cina", "Beijing");
            put("Malaysia", "Kuala Lumpur");
            put("Thailand", "Bangkok");
        }};

        // Display unsorted map
        System.out.println("Unsorted Map:");
        System.out.println(map);
        System.out.println("=".repeat(25));

        SortHashMap sortHashMap = new SortHashMap();
        // Sort the map by values
        Map<String, String> sortedMap = sortHashMap.sortByValues(map);

        // Display sorted map
        System.out.println("Sorted Map:");
        System.out.println(sortedMap);

        System.out.println("=".repeat(COUNT));
        System.out.println();
    }

    private void searchTextExample(){
        System.out.println("Search Text Example");
        System.out.println("=".repeat(COUNT));

        String fileName = "src/main/resources/sikancil.txt"; // File path
        String searchString = "kancil"; // The text to search for
        SearchText search = new SearchText();
        List<String> textFound = search.searchForText(fileName, searchString); // Perform text search

        // Print the found text
        for (String line : textFound) {
            System.out.println(line);
        }

        System.out.println("=".repeat(COUNT));
        System.out.println();
    }

    private void pyramidExample(){
        System.out.println("Pyramid Example");
        System.out.println("=".repeat(COUNT));

        Pyramid pyramid = new Pyramid();
        int n = 5;
        char symbol = '*';
        System.out.println("Jumlah n = "+n);
        pyramid.printPyramid(n, symbol);

        System.out.println("=".repeat(COUNT));
        System.out.println();
    }

    private void sortExample(){
        System.out.println("Merge Sort Example");
        System.out.println("=".repeat(COUNT));

        // Input array to be sorted
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));
        MergeSort sort = new MergeSort();
        // Sorting the array using merge sort
        sort.mergeSort(arr);

        // Printing the sorted array
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("=".repeat(COUNT));
        System.out.println();
    }

    private void sumArrayValuesExample(){
        System.out.println("Sum Array Values");
        System.out.println("=".repeat(COUNT));

        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        ArraySum sum = new ArraySum();
        sum.reduce(numbers);

        System.out.println("=".repeat(COUNT));
        System.out.println();
    }

}
