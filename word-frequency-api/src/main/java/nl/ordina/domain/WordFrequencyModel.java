package nl.ordina.domain;

public class WordFrequencyModel implements WordFrequency {

    private final String word;

    private final int frequency;

    public WordFrequencyModel(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    /**
     * @return the word
     */
    @Override
    public String getWord() {
        return word;
    }

    /**
     * @return the frequency of the word in the text
     */
    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return '(' + "\"" + word + "\"" + ", " + frequency + ')';
    }
}
