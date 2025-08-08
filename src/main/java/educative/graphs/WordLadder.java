package educative.graphs;

import java.util.*;

public class WordLadder {
    public static int wordLadderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || !wordList.contains(endWord)) {
            return 0; // Invalid input
        }

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return length; // Found the end word
                }

                for (String nextWord : getNextWords(currentWord, wordSet)) {
                    queue.offer(nextWord);
                }
            }
            length++;
        }

        return 0; // No transformation found
    }

    private static List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char originalChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != originalChar) {
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (wordSet.contains(newWord)) {
                        nextWords.add(newWord);
                    }
                }
            }
            chars[i] = originalChar; // Restore original character
        }

        return nextWords;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = wordLadderLength(beginWord, endWord, wordList);
        System.out.println("Length of the shortest transformation sequence: " + result); // Output: 5
    }
}
