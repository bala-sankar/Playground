package educative.strings;

import java.util.*;

/*
Problem Statement:
Given a string and a dictionary of words, determine if the string can be segmented into a space-separated sequence of one or more dictionary words.

Examples:
Input:  "applepie", dictionary = ["apple", "pie"]
Output: true

Input:  "applepeer", dictionary = ["apple", "pear", "pie"]
Output: false
*/

public class StringSegmentation {

    public static boolean segmentString(String inputString, Set<String> dictionary) {
        Map<String, Boolean> isWordAvailable = new HashMap<>();
        return segmentString(inputString, dictionary, 0, inputString.length(), isWordAvailable);
    }
    public static boolean segmentString(String inputString, Set<String> dictionary, int startIndex, int endIndex, Map<String, Boolean> isWordAvailable) {
        String word = inputString.substring(startIndex, endIndex);
        if (isWordAvailable.containsKey(word)) {
            return isWordAvailable.get(word);
        }
        if(word.isEmpty() || dictionary.contains(word)) {
            isWordAvailable.putIfAbsent(word, true);
            return true;
        }
        for (int i = startIndex + 1; i < endIndex; i++) {
            boolean word1 = segmentString(inputString, dictionary, startIndex, i, isWordAvailable);
            boolean word2 = segmentString(inputString, dictionary, i, endIndex, isWordAvailable);
            if (word1 && word2) {
                isWordAvailable.putIfAbsent(word, true);
                return true;
            } else {
                isWordAvailable.putIfAbsent(word, false);
            }
        }
        isWordAvailable.putIfAbsent(word, false);
        return false;
    }


    // Ignore this implementation
    public static boolean canSegmentString(String inputString, Set<String> dictionary) {
        for (int i=1; i < inputString.length(); i++) {
            String firstWord = inputString.substring(0, i);
            String secondWord = inputString.substring(i);


            if (dictionary.contains(firstWord)) {

                // Only first word is present, then the second word would be empty
                if (secondWord.isEmpty() || dictionary.contains(secondWord)) {
                    return true;
                }
                // Note: for "false", we try to process the next word
                if (canSegmentString(secondWord, dictionary)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] inputStr = {"hellonow", "nowok", "applepie", "applejuice"};
        String[][] wordsDictionary =
                {{"hello", "hell", "on", "now"}, {"hello", "hell", "on", "now"},
                        {"apple", "pear", "pier", "pie"}, {"apple", "pear", "pier", "pie"}};
        for (int i = 0; i < inputStr.length; i++) {
            Set<String> dict = new HashSet<String>(Arrays.asList(wordsDictionary[i]));

            System.out.println("   Input string: \"" + inputStr[i] + "\"");
            if (segmentString(inputStr[i], dict))
                System.out.println("   Result: String can be segmented");
            else
                System.out.println("   Result: String can not be segmented");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------\n");
        }

    }
}
