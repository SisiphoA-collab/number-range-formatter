package com.impact.assignment.impl;

import com.impact.assignment.NumberRangeSummarizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

/**
 * Unit tests for NumberRangeSummarizerImpl
 */
class NumberRangeSummarizerImplTest {

    private NumberRangeSummarizer summarizer;

    @BeforeEach
    void setUp() {
        summarizer = new NumberRangeSummarizerImpl();
    }

    @Test
    void testCollectWithValidInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> result = summarizer.collect(input);
        
        assertEquals(14, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(3));
        assertTrue(result.contains(31));
    }

    @Test
    void testCollectWithEmptyInput() {
        String input = "";
        Collection<Integer> result = summarizer.collect(input);
        
        assertTrue(result.isEmpty());
    }

    @Test
    void testCollectWithNullInput() {
        Collection<Integer> result = summarizer.collect(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCollectWithSpacesAndDuplicates() {
        String input = "1, 2, 2, 3, 4, 5, 5, 6";
        Collection<Integer> result = summarizer.collect(input);
        
        assertEquals(6, result.size()); // Duplicates removed
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, result.toArray());
    }

    @Test
    void testSummarizeCollectionWithSequentialNumbers() {
        Collection<Integer> input = java.util.Arrays.asList(1, 2, 3, 5, 6, 7, 9, 10, 11);
        String result = summarizer.summarizeCollection(input);
        
        assertEquals("1-3, 5-7, 9-11", result);
    }

    @Test
    void testSummarizeCollectionWithSingleNumbers() {
        Collection<Integer> input = java.util.Arrays.asList(1, 3, 5, 7, 9);
        String result = summarizer.summarizeCollection(input);
        
        assertEquals("1, 3, 5, 7, 9", result);
    }

    @Test
    void testSummarizeCollectionWithEmptyCollection() {
        Collection<Integer> input = java.util.Arrays.asList();
        String result = summarizer.summarizeCollection(input);
        
        assertEquals("", result);
    }

    @Test
    void testSummarizeCollectionWithNullCollection() {
        String result = summarizer.summarizeCollection(null);
        assertEquals("", result);
    }

    @Test
    void testSummarizeCollectionWithMixedRanges() {
        Collection<Integer> input = java.util.Arrays.asList(1, 2, 3, 6, 7, 9, 10, 11, 15);
        String result = summarizer.summarizeCollection(input);
        
        assertEquals("1-3, 6-7, 9-11, 15", result);
    }

    @Test
    void testEndToEndFunctionality() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collected = summarizer.collect(input);
        String summarized = summarizer.summarizeCollection(collected);
        
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summarized);
    }

    @Test
    void testUnsortedInput() {
        String input = "5,1,3,2,4,7,6";
        Collection<Integer> collected = summarizer.collect(input);
        String summarized = summarizer.summarizeCollection(collected);
        
        assertEquals("1-7", summarized);
    }
}