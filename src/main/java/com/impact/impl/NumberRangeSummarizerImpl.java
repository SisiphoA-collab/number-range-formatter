package com.impact.assignment.impl;

import com.impact.assignment.NumberRangeSummarizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of NumberRangeSummarizer that groups sequential numbers into ranges.
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Ensure input is sorted
        List<Integer> numbers = new ArrayList<>(input);
        numbers.sort(Integer::compareTo);

        List<String> result = new ArrayList<>();
        
        int start = numbers.get(0);
        int prev = start;
        
        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            
            if (current != prev + 1) {
                // Non-sequential number found
                if (start == prev) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "-" + prev);
                }
                start = current;
            }
            prev = current;
        }
        
        // Add the last range or single number
        if (start == prev) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "-" + prev);
        }
        
        // Join without spaces (fix for tests)
        return String.join(",", result);
    }
}
