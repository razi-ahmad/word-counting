package nl.ordina.analyzer;

import nl.ordina.domain.WordFrequency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzerImplTest {

    private static final String text = "The sun shines over the lake";

    private WordFrequencyAnalyzer underTest;

    @BeforeEach
    public void setUp() {
        underTest = new WordFrequencyAnalyzerImpl();
    }

    @Test
    public void test_calculate_highest_frequency() {
        int result = underTest.calculateHighestFrequency(text);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_calculate_highest_frequency_when_null() {
        int result = underTest.calculateHighestFrequency(null);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_highest_frequency_when_empty() {
        int result = underTest.calculateHighestFrequency("");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_frequency_for_word() {
        int result = underTest.calculateFrequencyForWord(text, "the");
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_calculate_frequency_for_word_case_insensitive() {
        int result = underTest.calculateFrequencyForWord(text, "THE");
        Assertions.assertEquals(2, result);
    }

    @Test
    public void test_calculate_frequency_for_word_when_text_null() {
        int result = underTest.calculateFrequencyForWord(null, "the");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_frequency_for_word_when_word_null() {
        int result = underTest.calculateFrequencyForWord(text, null);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_frequency_for_word_when_text_empty() {
        int result = underTest.calculateFrequencyForWord("", "the");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_frequency_for_word_when_word_empty() {
        int result = underTest.calculateFrequencyForWord(text, "");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_frequency_for_word_when_text_word_null() {
        int result = underTest.calculateFrequencyForWord(null, null);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_frequency_for_word_when_text_word_empty() {
        int result = underTest.calculateFrequencyForWord("", "");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void test_calculate_most_frequent_n_words() {
        List<WordFrequency> wordFrequencies = underTest.calculateMostFrequentNWords(text, 3);
        Assertions.assertEquals(3, wordFrequencies.size());
        Assertions.assertEquals("{(\"the\", 2),(\"lake\", 1),(\"over\", 1)}", wordFrequencies.stream().map(Object::toString).collect(Collectors.joining(",", "{", "}")));
    }

    @Test
    public void test_calculate_most_frequent_zero_words() {
        List<WordFrequency> wordFrequencies = underTest.calculateMostFrequentNWords(text, 0);
        Assertions.assertEquals(0, wordFrequencies.size());
    }

    @Test
    public void test_calculate_most_frequent_n_words_when_text_null() {
        List<WordFrequency> wordFrequencies = underTest.calculateMostFrequentNWords(null, 3);
        Assertions.assertEquals(0, wordFrequencies.size());
    }

    @Test
    public void test_calculate_most_frequent_n_words_when_length_is_greater_than_distinct_words() {
        List<WordFrequency> wordFrequencies = underTest.calculateMostFrequentNWords(text, 6);
        Assertions.assertEquals(5, wordFrequencies.size());
    }

    @Test
    public void test_calculate_most_frequent_n_words_when_n_is_negative() {
        List<WordFrequency> wordFrequencies = underTest.calculateMostFrequentNWords(text, -1);
        Assertions.assertEquals(0, wordFrequencies.size());
    }
}