package com.impact.assignment;

import java.util.Collection;

/**
 * Interface to be implemented for the number range summarization exercise.
 */
public interface NumberRangeSummarizer {

    /**
     * Collects the input string and returns a collection of integers.
     * 
     * @param input the input string containing comma-delimited numbers
     * @return a collection of integers
     */
    Collection<Integer> collect(String input);

    /**
     * Groups sequential numbers into ranges and returns a comma-delimited string.
     * 
     * @param input the collection of integers
     * @return a comma-delimited string with sequential numbers grouped into ranges
     */
    String summarizeCollection(Collection<Integer> input);
}