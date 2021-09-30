package nl.ordina.domain;


public interface WordFrequency {
    /**
     * @return the word
     */
    String getWord();

    /**
     * @return the frequency of the word in the text
     */
    int getFrequency();
}
