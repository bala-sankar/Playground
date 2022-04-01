package educative.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {
    public static void main(String[] args) {
        char[] sentences = new char[]{'w', 'e', ' ', 'l', 'o', 'v', 'e', ' ', 'j', 'a', 'v', 'a'};
        removeDuplicates(sentences);
    }
    static String removeDuplicates(char[] str) {
        Set<Character> characterBag = new LinkedHashSet<>();
        for(char c : str){
            characterBag.add(c);
        }
        char[] result =  new char[characterBag.size()];
        int i = 0;
        for(Character c :  characterBag) {
            result[i] = c;
            i++;
        }
        return String.valueOf(result);
    }
}
