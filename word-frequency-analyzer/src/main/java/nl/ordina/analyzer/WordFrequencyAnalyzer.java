package nl.ordina.analyzer;

import nl.ordina.domain.WordFrequency;

import java.util.List;

public interface WordFrequencyAnalyzer {

    /**
     *
     * @param text is the input string
     * @return the highest frequency in the text (Several words might have this frequency)
     */
    int calculateHighestFrequency(String text);

    /**
     *
     * @param text is the input string
     * @param word frequency will be calculated
     * @return the frequency of the specified word
     */
    int calculateFrequencyForWord(String text, String word);

    /**
     *
     * @param text is the input string
     * @param n number of most frequent objects should be return
     * @return return a list of the most frequent "n" words in the input text, all the words returned in lower case. If server words have the same
     * frequency, this method should return them in ascendant alphabetical order (for input text "The sun shines over the lake" and n = 3, it should
     * return the list {("the",2),("lake",1),("over",1)}
     */
    List<WordFrequency> calculateMostFrequentNWords(String text, int n);
}
