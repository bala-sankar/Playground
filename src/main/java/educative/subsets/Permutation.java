package educative.subsets;

import java.util.ArrayList;

import static java.util.Collections.swap;

public class Permutation {
    public static ArrayList<String> permuteWord(String word) {

        if (word.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        permutate(word.toCharArray(), 0, result);
        return result;
    }


    static void permutate(char[] word, int index, ArrayList<String> result) {
        if (index == word.length) {
            result.add(new String(word));
            return;
        }
        for (int i = index; i < word.length; i++) {
            swap(word, index, i);
            permutate(word, index + 1, result);
            swap(word, index, i);
        }
    }

    static void swap(char[] word, int i, int j) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
}
