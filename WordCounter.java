import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        // Check if at least one file has been provided as an argument
        if (args.length == 0) {
            System.out.println("Please provide at least one input file");
            return;
        }

        // Create a map to store the count of each word
        Map<String, Integer> wordCount = new HashMap<>();

        // Read each file and count the occurrences of each word
        for (String fileName : args) {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\s+");
                // Increment the count for each word
                for (String word : words) {
                    word = word.toLowerCase();
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
            reader.close();
        }

        // Print the count for each word
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
