package WordCount;

import java.io.File;
import java.util.*;

public class WordCountAlice {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("Alice.txt"));
        Map<String, Integer> wordsHashMap = new HashMap();
        List<String> words = new ArrayList<>();
        // adding all words from the file to the words list
        while (file.hasNext()) {
            String s = file.next().toLowerCase();
            // this non alphanumeric trimming is not working ask Jon for help
            s = s.replaceAll("[^a-zA-Z]+","");
            words.add(s);
        }
        // mapping the strings from words list to a hash map where the values are the number of occurrences
        for (String s : words
                ) {
            if (!wordsHashMap.containsKey(s)) {
                wordsHashMap.put(s, 1);
            } else {
                wordsHashMap.put(s, wordsHashMap.get(s) + 1);
            }
        }

        // convert hashmap to List with an iteration order from a linkedList
        List<Map.Entry<String, Integer>> wordHmToList = new LinkedList<>(wordsHashMap.entrySet());
        // sorting the list with a compare to using lambda from biggest to smallest values
        wordHmToList.sort((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o2.getValue() - o1.getValue());
        // printing the sorted list
        wordHmToList.forEach((Entry)-> System.out.println(Entry));

    }
}
