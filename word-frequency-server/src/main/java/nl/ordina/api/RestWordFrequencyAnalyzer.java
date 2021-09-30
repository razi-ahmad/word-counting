package nl.ordina.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import nl.ordina.analyzer.WordFrequencyAnalyzer;

import java.util.Objects;
import java.util.stream.Collectors;

@Path("/words")
public class RestWordFrequencyAnalyzer {

    private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @Inject
    public RestWordFrequencyAnalyzer(WordFrequencyAnalyzer wordFrequencyAnalyzer) {
        this.wordFrequencyAnalyzer = wordFrequencyAnalyzer;
    }

    @GET
    @Path("/highest-frequency")
    @Produces(MediaType.TEXT_PLAIN)
    public int calculateHighestFrequency(@QueryParam("text") String text) {
        return wordFrequencyAnalyzer.calculateHighestFrequency(text);
    }

    @GET
    @Path("/frequency-for-word")
    @Produces(MediaType.TEXT_PLAIN)
    public int calculateFrequencyForWord(@QueryParam("text") String text, @QueryParam("word") String word) {
        return wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
    }

    @GET
    @Path("/most-n-frequent")
    @Produces(MediaType.APPLICATION_JSON)
    public String calculateMostFrequentNWords(@QueryParam("text") String text, @QueryParam("nFrequentWords") Integer nFrequentWords) {
        if (Objects.isNull(nFrequentWords)) return "";

        return wordFrequencyAnalyzer.calculateMostFrequentNWords(text, nFrequentWords)
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "{", "}"));
    }
}
