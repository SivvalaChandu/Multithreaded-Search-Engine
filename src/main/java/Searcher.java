import java.util.List;

public class Searcher extends Thread {
    private String query;
    private InvertedIndex invertedIndex;

    public Searcher(String query, InvertedIndex invertedIndex) {
        this.query = query;
        this.invertedIndex = invertedIndex;
    }

    @Override
    public void run() {
        String[] tokens = query.split(" ");
        for(String word : tokens){
            word = word.toLowerCase();
            List<String> results = invertedIndex.search(word);
            if(!results.isEmpty()) {
                System.out.println("Word: " + word + "\nResults: " + results+"\n");
            }
            else {
                System.out.println("No results found for word: " + word);
            }
        }
    }
}
