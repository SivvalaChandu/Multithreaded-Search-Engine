# ⚡ Multithreaded Search Engine ⚡

This project implements a multithreaded search system in Java. It scans a directory for `.txt`, `.pdf`, and `.doc` files, indexes their content, and allows users to search for words within the indexed files.

## Features

- Multithreaded file indexing using Java's `ExecutorService`.
- Support for indexing `.txt`, `.pdf`, and `.doc` file formats.
- Search functionality that returns the file paths where the searched words appear.
- Removal of common stopwords from the search queries.

## Requirements

- Java Development Kit (JDK) 8 or higher.
- Apache Maven.
- The following Maven dependencies for handling PDF and Word files:
  ```xml
  <dependency>
      <groupId>org.apache.pdfbox</groupId>
      <artifactId>pdfbox</artifactId>
      <version>2.0.24</version>
  </dependency>
  <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi</artifactId>
      <version>5.2.3</version>
  </dependency>
  <dependency>
      <groupId>org.apache.poi</groupId>
      <artifactId>poi-scratchpad</artifactId>
      <version>5.2.3</version>
  </dependency>
  ```

## Getting Started

### 1.Clone the repository:

```
git clone https://github.com/SivvalaChandu/Multithreaded-Search-Engine.git
cd MultithreadedSearchEngine
```

### 2.Navigate to the project directory: Make sure to replace the directory path in Main.java with the directory that contains your .txt, .pdf, and .doc files.

```
File directory = new File("ENTER_YOUR_DIR_PATH");
```

### 3.Build the project using Maven:

```
mvn clean install
```

### 4.Run the project:

```
mvn exec:java -Dexec.mainClass="Main"
```

### 5.Interact with the application:

-After running the application, it will scan the specified directory for files and index them.
-Enter the words you want to search when prompted. The program will display the results.

## Example Input/Output

-Input: Enter words you want to search:
-Output:

```
Word: example
Results: [path_of_word_in_file.txt, path_of_word_in_file.doc]

No results found for word: new

```

## Notes

-Ensure that you have the necessary permissions to access the files in the specified directory.
-The application will remove common stopwords from the search queries to enhance the search experience.

### How to Run the Project

```
1. Clone the repository using `git`.
2. Change the directory to the project folder.
3. Make sure you have the necessary files in the specified directory.
4. Build the project with Maven using `mvn clean install`.
5. Run the project with `mvn exec:java -Dexec.mainClass="Main"`.

Feel free to modify any sections to better suit your project's needs!
```
