package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {
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
}
