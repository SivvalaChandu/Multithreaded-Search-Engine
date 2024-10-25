import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        InvertedIndex invertedIndex = new InvertedIndex();

        File directory = new File("ENTER_YOUR_DIR_PATH");
        File[] files = directory.listFiles();

        System.out.println(" Scanning files...");

        if (files != null && files.length > 0) {
            // Create a fixed thread pool (adjust the number of threads as needed)
            ExecutorService executor = Executors.newFixedThreadPool(4); // For example, using 4 threads

            // Submit indexing tasks
            for (File file : files) {
                executor.execute(new FileIndexer(file, invertedIndex));
            }

            executor.shutdown();

            // Wait for all tasks to complete
            while (!executor.isTerminated()) {}

            System.out.println("File Scanning Completed.");

            System.out.println("Enter words you want to search: ");

            Scanner sc = new Scanner(System.in);
            String queries = sc.nextLine();
            String[] queryWords = StopWords.removeStopwords(queries);
            System.out.println();

            // Create a new executor for searching
            ExecutorService searchExecutor = Executors.newFixedThreadPool(4);

            // Submit search tasks
            for (String word : queryWords) {
                searchExecutor.execute(new Searcher(word, invertedIndex));
            }

            // Shutdown the search executor after submitting tasks
            searchExecutor.shutdown();

            // Wait for all search tasks to complete
            while (!searchExecutor.isTerminated()) {}
            sc.close();
        }
    }
}
