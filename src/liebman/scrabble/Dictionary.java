package liebman.scrabble;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private File file;
    private Map<String, String> dictionary = new HashMap<String, String>();

    public Dictionary(String filePath) throws FileNotFoundException {
        this.file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String nextWord = scanner.next();
            String definition = scanner.nextLine();
            dictionary.put(nextWord, definition);
        }
    }

    public boolean validateWord(String input){
        return dictionary.containsKey(input.toUpperCase());
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
}