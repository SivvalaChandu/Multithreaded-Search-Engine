import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class FileIndexer extends Thread {
    private final File file;
    private final InvertedIndex invertedIndex;

    public FileIndexer(File file, InvertedIndex invertedIndex) {
        this.file = file;
        this.invertedIndex = invertedIndex;
    }

    @Override
    public void run() {
        try {
            if (file.getName().endsWith(".txt")) {
                indexTextFile();
            } else if (file.getName().endsWith(".pdf")) {
                indexPDFFile();
            } else if (file.getName().endsWith(".doc")) {
                indexDocFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void indexTextFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lineString;
            while ((lineString = reader.readLine()) != null) {
                String[] words = lineString.split(" ");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!word.isEmpty()) {
                        invertedIndex.addDocuments(word, file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private void indexPDFFile() throws IOException {
        try (PDDocument document = Loader.loadPDF(file)) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            String[] words = text.split(" ");
            for (String word : words) {
                word = word.toLowerCase();
                if (!word.isEmpty()) {
                    invertedIndex.addDocuments(word, file.getAbsolutePath());
                }
            }
        }
    }

    private void indexDocFile() throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             HWPFDocument document = new HWPFDocument(fis);
             WordExtractor extractor = new WordExtractor(document)) {
            String[] words = extractor.getText().split("\\W+");
            for (String word : words) {
                word = word.toLowerCase();
                if (!word.isEmpty()) {
                    invertedIndex.addDocuments(word, file.getAbsolutePath());
                }
            }
        }
    }
}
