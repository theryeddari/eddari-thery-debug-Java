package com.hemebiotech.analytics;

import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.services.AnalyticsCounter;
import com.hemebiotech.analytics.services.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.services.WriteSymptomDataToFile;

import java.util.List;
import java.util.Map;

/**
 * The main class that performs symptom analytics.
 */
public class Main {

    /**
     * The entry point of the program.
     *
     * @param args The command line arguments, not use.
     */
    public static void main(String[] args) {
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> symptomsCounted = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> symptomsSorted = analyticsCounter.sortSymptoms(symptomsCounted);
        analyticsCounter.writeSymptoms(symptomsSorted);
    }
}
