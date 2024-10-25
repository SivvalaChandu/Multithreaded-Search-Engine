import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {
    private Map<String, List<String>> indexs = new HashMap<>();

    public synchronized void addDocuments(String word, String filePath) {
        indexs.computeIfAbsent(word, not ->  new ArrayList<>()).add(filePath);
    }

    public List<String> search(String word) {
        return indexs.getOrDefault(word, new ArrayList<>());
    }

    public void display() {
        for(Map.Entry<String, List<String>> entry : indexs.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
