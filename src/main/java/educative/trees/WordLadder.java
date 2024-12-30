package educative.trees;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class WordLadder {
    public static int wordLadder(String src, String dest, List<String> words) {
        Set<String> wordSet = Set.copyOf(words);
        return wordLadder(src, dest, wordSet);
    }

    private static int wordLadder(String src, String dest, Set<String> words) {
        if (src.equals(dest)) {
            return 0;
        }
        if (words.isEmpty()) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (String word : words) {
            if (isAdjacent(src, word)) {
                Set<String> newWords = new HashSet<>(words);
                newWords.remove(word);
                int count = wordLadder(word, dest, newWords);
                if (count != 0) {
                    min = Math.min(min, count + 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private static boolean isAdjacent(String src, String dest) {
        int count = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) != dest.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}

/*
// Working Solution but hard to read

public class WordLadder {


    public static int wordLadder(String src, String dest, List<String> words) {
        // Create a set of words for faster lookup
        Set<String> mySet = new HashSet<>(words);
        // If the dest is not in the set, return 0
        if (!mySet.contains(dest))
            return 0;
        // Create a queue for the words to be checked
        Queue<String> q = new LinkedList<>();
        q.offer(src);
        // Initialize the length counter
        int length = 0;

        // Check words until the queue is empty
        while (!q.isEmpty()) {
            length++;
            // Store the length of the queue
            int size = q.size();
            // Check all the words in the current level
            for (int i = 0; i < size; i++) {
                // Pop a word from the queue
                String curr = q.poll();
                // Iterate on each character of the popped word
                for (int j = 0; j < curr.length(); j++) {
                    String alpha = "abcdefghijklmnopqrstuvwxyz";
                    // Iterate with all possible characters
                    for (int k = 0; k < alpha.length(); k++) {
                        // Create a new word by replacing the jth character of the popped word
                        char[] temp = curr.toCharArray();
                        temp[j] = alpha.charAt(k);
                        String newWord = new String(temp);
                        // Check if the new word is the dest
                        if (newWord.equals(dest))
                            return length + 1;
                        // Check if the new word is in the set
                        // If it is, push it into the queue and remove it from the set
                        if (mySet.contains(newWord)) {
                            q.offer(newWord);
                            mySet.remove(newWord);
                        }
                    }
                }
            }
        }
        // Return 0 if no sequence exists
        return 0;
    }

}


 */