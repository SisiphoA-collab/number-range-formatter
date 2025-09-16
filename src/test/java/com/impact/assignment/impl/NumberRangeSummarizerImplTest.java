package com.impact.assignment.impl;

import com.impact.assignment.NumberRangeSummarizer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void testCollectValidInput() {
        Collection<Integer> numbers = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31), numbers);
    }

    @Test
    void testSummarizeSequentialRanges() {
        String result = summarizer.summarizeCollection(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
        assertEquals("1,3,6-8,12-15,21-24,31", result);
    }

    @Test
    void testEmptyInput() {
        String result = summarizer.summarizeCollection(Arrays.asList());
        assertEquals("", result);
    }

    @Test
    void testSingleNumber() {
        String result = summarizer.summarizeCollection(Arrays.asList(5));
        assertEquals("5", result);
    }

    @Test
    void testUnsortedInput() {
        // if you decide to sort input in your implementation
        String result = summarizer.summarizeCollection(Arrays.asList(4, 2, 1, 3));
        assertEquals("1-4", result);
    }
}
