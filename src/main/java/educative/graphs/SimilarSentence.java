package educative.graphs;

public class SimilarSentence {
    public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, String[][] similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false; // Sentences of different lengths cannot be similar
        }

        // Create a mapping of similar words
        java.util.Map<String, java.util.Set<String>> similarMap = new java.util.HashMap<>();
        for (String[] pair : similarPairs) {
            similarMap.putIfAbsent(pair[0], new java.util.HashSet<>());
            similarMap.putIfAbsent(pair[1], new java.util.HashSet<>());
            similarMap.get(pair[0]).add(pair[1]);
            similarMap.get(pair[1]).add(pair[0]);
        }

        // Check each word in the sentences
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (!word1.equals(word2)) {
                // If the words are not equal, check if they are similar
                if (!similarMap.containsKey(word1) || !similarMap.get(word1).contains(word2)) {
                    return false; // Not similar and not equal
                }
            }
        }

        return true; // All words are either equal or similar
    }
}
