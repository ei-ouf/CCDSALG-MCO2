package com.GraphClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    /*
     * This function reads a file from the given path, and
     * returns an array of Record objects representing the
     * data that was read.
     */
    public RelationshipRecord[] readFile(String path) {
        try {
            File f = new File(path);
            Scanner scanner = new Scanner(f);
            int n = scanner.nextInt(); // Get the number of accounts
            int e = scanner.nextInt(); // Get number of total relationships
            RelationshipRecord[] relationships = new RelationshipRecord[2500]; // Initialize array of records
            for (int i = 0; i < n; i++) { // Loop through each record
                int person1 = scanner.nextInt(); // get person1
                int person2 = scanner.nextInt(); // get person2
                RelationshipRecord record = new RelationshipRecord(person1, person2); // instantiate a new Record object
                relationships[i] = record; // Store the record in the array
            }

            scanner.close();
            return relationships;
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
            return null;
        }
    }
}
