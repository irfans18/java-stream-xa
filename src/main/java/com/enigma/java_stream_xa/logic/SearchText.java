package com.enigma.java_stream_xa.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides functionality to search for a specific text in a text file.
 */
public class SearchText {

    /**
     * Search for a specific text in a text file.
     *
     * @param fileName     The path of the text file to search.
     * @param searchString The text to search for.
     * @return A list of strings containing the found text.
     */
    public List<String> searchForText(String fileName, String searchString) {
        List<String> textFound = new ArrayList<>(); // Initiate List
        try (Scanner scanner = new Scanner(new File(fileName))) { // Opening File
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNumber++;
                if (line.toLowerCase().contains(searchString)) { // Search Text
                    textFound.add(String.format("String ditemukan pada line %d: ", lineNumber) + line);
                }
            }
        } catch (FileNotFoundException e) { // Exception Handling
            System.err.println("File tidak ditemukan: " + e.getMessage());
        }
        return textFound; // Return Result
    }
}
