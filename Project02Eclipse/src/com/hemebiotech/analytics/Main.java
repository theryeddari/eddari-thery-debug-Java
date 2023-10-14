package com.hemebiotech.analytics;

import com.hemebiotech.analytics.interfaces.ISymptomReader;
import com.hemebiotech.analytics.interfaces.ISymptomWriter;
import com.hemebiotech.analytics.services.AnalyticsCounter;
import com.hemebiotech.analytics.services.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.services.WriteSymptomDataToFile;

public class Main {

    public static void main(String[] args) {
        ISymptomReader symptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter symptomWriter = new WriteSymptomDataToFile();
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(symptomReader, symptomWriter);
    }
}
