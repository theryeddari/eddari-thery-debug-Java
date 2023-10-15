package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.interfaces.ISymptomWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * A class that writes symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filePath;

    /**
     * Constructs a WriteSymptomDataToFile object with the given file path.
     *
     * @param filePath The path of the file to write the symptom data to.
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes the symptoms and their counts to a file.
     *
     * @param symptoms The map of symptoms and their counts.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String symptom = entry.getKey();
                int number = entry.getValue();
                writer.write(symptom + ": " + number);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("An error occurred while accessing or writing the file");
        }
        System.out.println("The file has been created successfully :)");
    }
}
