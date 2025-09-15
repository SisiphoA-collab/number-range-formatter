# Number Range Summarizer

A Java implementation that groups sequential numbers into ranges and produces a comma-delimited list.

## Features

- Parses comma-delimited input strings into collections of integers
- Groups sequential numbers into ranges (e.g., 1,2,3 becomes "1-3")
- Handles edge cases like empty input, null values, and duplicates
- Uses Java 8 features including streams and lambda expressions

## Requirements

- Java 8 or higher
- Maven 3.6+ (for building and testing)

## Usage

```java
NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

// Collect numbers from input string
Collection<Integer> numbers = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");

// Summarize into ranges
String result = summarizer.summarizeCollection(numbers);
// Result: "1, 3, 6-8, 12-15, 21-24, 31"