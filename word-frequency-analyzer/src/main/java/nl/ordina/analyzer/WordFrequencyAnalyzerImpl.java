package nl.ordina.analyzer;

import jakarta.enterprise.inject.Model;
import nl.ordina.domain.WordFrequency;
import nl.ordina.domain.WordFrequencyModel;
import nl.ordina.util.Constant;

import java.util.*;

@Model
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    private static final Comparator<WordFrequency> wordFrequencyComparator = (o1, o2) -> {
        if (o1.getFrequency() == o2.getFrequency()) {
            return o1.getWord().compareTo(o2.getWord());
        } else {
            return Integer.compare(o2.getFrequency(), o1.getFrequency());
        }
    };

    @Override
    public int calculateHighestFrequency(String text) {
        Map<String, Integer> wordsCount = calculateFrequency(text);
        if (wordsCount.isEmpty()) return 0;

        PriorityQueue<Integer> frequencies = new PriorityQueue<>(Comparator.reverseOrder());
        wordsCount.forEach((word, frequency) -> frequencies.add(frequency));
        return frequencies.peek();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        if (Objects.isNull(word) || word.trim().length() == 0) return 0;
        return calculateFrequency(text).getOrDefault(word.toLowerCase(), 0);
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        if (n < 1) return Collections.EMPTY_LIST;

        Map<String, Integer> wordsCount = calculateFrequency(text);
        if (wordsCount.isEmpty()) return Collections.EMPTY_LIST;

        int index = 0;
        PriorityQueue<WordFrequency> frequencies = new PriorityQueue<>(wordFrequencyComparator);
        calculateFrequency(text).forEach((word, frequency) -> frequencies.add(new WordFrequencyModel(word, frequency)));
        List<WordFrequency> mostNWordFrequencies = new ArrayList<>();

        while (!frequencies.isEmpty() && index < n) {
            mostNWordFrequencies.add(frequencies.poll());
            index++;
        }
        return mostNWordFrequencies;
    }

    private Map<String, Integer> calculateFrequency(String text) {
        if (Objects.isNull(text) || text.trim().length() == 0) return Collections.EMPTY_MAP;

        Map<String, Integer> wordsCount = new TreeMap<>();
        Arrays.stream(text.trim().split(Constant.SPACE)).forEach(word -> wordsCount.merge(word.toLowerCase(), 1, Integer::sum));
        return wordsCount;
    }
}
