package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;
    private final ISymptomReader symptomReader;
    private final ISymptomWriter symptomWriter;

    public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
        this.symptomReader = symptomReader;
        this.symptomWriter = symptomWriter;
    }
    public List<String> getSymptoms() {
        return symptomReader.getSymptoms();
    }
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsCountMap = new HashMap<>();
        for (String symptom : symptoms) {
            symptomsCountMap.merge(symptom, 1, Integer::sum);
        }
        return symptomsCountMap;
    }
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

        return new TreeMap<>(symptoms);
    }
    public void writeSymptoms(Map<String, Integer> symptoms) {
        symptomWriter.writeSymptoms(symptoms);
    }
    public static void main(String[] args) throws Exception {
        // first get input
        try (BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"))) {
            String line = reader.readLine();

            while (line != null) {
                System.out.println("symptom from file: " + line);
                if (line.equals("headache")) {
                    headacheCount++;
                    System.out.println("number of headaches: " + headacheCount);
                } else if (line.equals("rash")) {
                    rashCount++;
                    System.out.println("number of rash: " + rashCount);
                } else if (line.contains("dialated pupils")) {
                    pupilCount++;
                    System.out.println("number of dialated pupils: " + pupilCount);
                }

                line = reader.readLine();
            }
        }
        try (FileWriter writer = new FileWriter("result.out")) {
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dialated pupils: " + pupilCount + "\n");
        }
    }
}
