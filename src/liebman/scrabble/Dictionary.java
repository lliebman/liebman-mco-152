package liebman.scrabble;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private File file = new File("src/liebman/scrabble/dictionary.txt");
    private Map<String, String> dictionary = new HashMap<String, String>();

    public Dictionary() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String nextWord = scanner.next();
            String definition = scanner.nextLine();
            dictionary.put(nextWord, definition);
        }
    }

    public boolean validateWord(String input){
        boolean v = dictionary.containsKey(input.toUpperCase());
        return v;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
}