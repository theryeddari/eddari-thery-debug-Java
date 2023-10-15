package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class that performs analytics on a list of symptoms.
 */
public class AnalyticsCounter {
    private final ISymptomReader symptomReader;
    private final ISymptomWriter symptomWriter;

    /**
     * Constructs an AnalyticsCounter object with the given symptom reader and symptom writer.
     *
     * @param symptomReader The symptom reader implementation.
     * @param symptomWriter The symptom writer implementation.
     */
    public AnalyticsCounter(ISymptomReader symptomReader, ISymptomWriter symptomWriter) {
        this.symptomReader = symptomReader;
        this.symptomWriter = symptomWriter;
    }

    /**
     * Retrieves the list of symptoms.
     *
     * @return The list of symptoms.
     */
    public List<String> getSymptoms() {
        return symptomReader.getSymptoms();
    }

    /**
     * Counts the occurrences of each symptom in the given list of symptoms.
     *
     * @param symptoms The list of symptoms.
     * @return A map containing the symptoms as keys and their counts as values.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomsCountMap = new HashMap<>();
        for (String symptom : symptoms) {
            symptomsCountMap.merge(symptom, 1, Integer::sum);
        }
        return symptomsCountMap;
    }

    /**
     * Sorts the symptoms in alphabetical order.
     *
     * @param symptoms The map of symptoms and their counts.
     * @return A sorted map of symptoms and their counts.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * Writes the symptoms and their counts.
     *
     * @param symptoms The map of symptoms and their counts.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        symptomWriter.writeSymptoms(symptoms);
    }
}
