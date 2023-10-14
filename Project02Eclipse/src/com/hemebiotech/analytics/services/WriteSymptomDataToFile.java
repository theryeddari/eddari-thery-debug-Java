package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.interfaces.ISymptomWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    public void writeSymptoms(Map<String, Integer> symptoms){

            //use try with resource in parentheses to automatically close.
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))){
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    String symptom = entry.getKey();
                    int number = entry.getValue();
                    writer.write(symptom + ": " + number);
                    writer.newLine();
                }
            } catch (IOException e) {
                throw new IllegalStateException("Problème d'accès en écriture ou lecture");
            }
            System.out.println("Le fichier a été correctement créé :)");
    }
}