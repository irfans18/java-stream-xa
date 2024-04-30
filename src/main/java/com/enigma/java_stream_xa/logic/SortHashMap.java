package com.enigma.java_stream_xa.logic;

import java.util.*;

/**
 * Provides functionality to sort a HashMap by its values.
 */
public class SortHashMap {
    /**
     * Sorts a HashMap by its values in ascending order.
     *
     * @param map The HashMap to be sorted.
     * @return A LinkedHashMap containing the sorted entries based on values.
     */
    public Map<String, String> sortByValues(Map<String, String> map) {
        // Convert the map entries to a list and sort them using a custom comparator
        List<Map.Entry<String, String>> list = map.entrySet().stream().sorted(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        }).toList();

        // Reconstruct the sorted map using LinkedHashMap to preserve insertion order
        Map<String, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
