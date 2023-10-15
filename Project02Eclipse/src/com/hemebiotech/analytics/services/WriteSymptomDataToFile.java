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

    /**
     * Writes the symptoms and their counts to a file.
     *
     * @param symptoms The map of symptoms and their counts.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {
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
