package com.hemebiotech.analytics.interfaces;

import java.util.Map;

/**
 * An interface for writing symptom data.
 */
public interface ISymptomWriter {

    /**
     * Writes the symptoms and their counts.
     *
     * @param symptoms The map of symptoms and their counts.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
