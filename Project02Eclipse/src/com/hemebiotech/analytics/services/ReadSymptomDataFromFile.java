package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.interfaces.ISymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filePath;

    /**
     * Constructs a new ReadSymptomDataFromFile object.
     *
     * @param filePath a full path to the file with symptoms
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the symptoms from the file and returns a list of symptoms.
     *
     * @return a list of symptoms
     * @throws IllegalStateException if there is an error accessing or reading the file
     */
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<>();

        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error accessing or reading the file");
            }
        }

        return result;
    }

}
