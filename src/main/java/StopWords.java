import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StopWords {

    private static final Set<String> STOPWORDS = new HashSet<>(Arrays.asList(
            "a", "about", "above", "after", "again", "against", "all", "am",
            "an", "and", "any", "are", "aren't", "as", "at", "be", "because",
            "been", "before", "being", "between", "both", "but", "by", "can",
            "can't", "cannot", "could", "couldn't", "did", "didn't", "do",
            "does", "doesn't", "doing", "don't", "down", "during", "each",
            "few", "for", "from", "further", "had", "hadn't", "has", "hasn't",
            "have", "haven't", "having", "he", "he'd", "he'll", "he's",
            "her", "here", "here's", "hers", "herself", "him", "himself",
            "his", "how", "how's", "i", "i'd", "i'll", "i'm", "i've", "if",
            "in", "into", "is", "isn't", "it", "it's", "its", "itself",
            "just", "ll", "m", "ma", "me", "might", "mightn't", "more",
            "most", "must", "mustn't", "my", "myself", "need", "needn't",
            "no", "nor", "not", "now", "of", "off", "on", "once", "only",
            "or", "other", "our", "ours", "ourselves", "out", "over", "own",
            "re", "s", "same", "sh", "she", "she'd", "she'll", "she's",
            "should", "shouldn't", "so", "some", "such", "t", "than",
            "that", "that'll", "the", "their", "theirs", "them",
            "themselves", "then", "there", "there's", "these", "they",
            "they'd", "they'll", "they're", "they've", "this", "those",
            "through", "to", "too", "under", "until", "up", "ve", "very",
            "was", "wasn't", "we", "we'd", "we'll", "we're", "we've",
            "were", "weren't", "what", "what's", "when", "when's", "where",
            "where's", "which", "while", "who", "who's", "whom", "why",
            "why's", "will", "with", "won't", "would", "wouldn't", "y",
            "you", "you'd", "you'll", "you're", "you've", "your", "yours",
            "yourself", "yourselves"
    ));


    public static String[] removeStopwords(String input) {

        String[] words = input.split(" ");
        
        // Filter out stopwords and return the result
        return Arrays.stream(words)
                .filter(word -> !STOPWORDS.contains(word.toLowerCase()))
                .toArray(String[]::new);
    }
}
