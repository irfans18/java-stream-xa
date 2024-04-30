package com.enigma.java_stream_xa.logic;

import java.util.Arrays;

/**
 * Class to demonstrate Merge Sort algorithm.
 */
public class MergeSort {
    /**
     * Method to perform merge sort recursively.
     *
     * @param arr The array to be sorted.
     */
    public void mergeSort(int[] arr) {
        // If the array has more than one element
        if (arr.length > 1) {
            // Calculate the middle index of the array
            int mid = arr.length / 2;

            // Split the array into two halves
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            // Recursively sort the left half
            mergeSort(left);
            // Recursively sort the right half
            mergeSort(right);

            // Merge the sorted halves
            int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
            while (leftIndex < left.length && rightIndex < right.length) {
                // Compare elements from left and right halves and merge them into arr
                if (left[leftIndex] < right[rightIndex]) {
                    arr[mergedIndex++] = left[leftIndex++];
                } else {
                    arr[mergedIndex++] = right[rightIndex++];
                }
            }

            // Copy any remaining elements from left half
            while (leftIndex < left.length) {
                arr[mergedIndex++] = left[leftIndex++];
            }

            // Copy any remaining elements from right half
            while (rightIndex < right.length) {
                arr[mergedIndex++] = right[rightIndex++];
            }
        }
    }
}
