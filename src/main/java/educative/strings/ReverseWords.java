package educative.strings;

public class ReverseWords {
    public static String reverseWords(char[] sentence) {
        if (sentence == null || sentence.length == 0) {
            return "";
        }

        // Reverse the sentence
        stringReverse(sentence, 0, sentence.length - 1);
        // Reverse each word
        int i = 0, j = 0;
        while(true) {
            if(i >= sentence.length - 1) {
                break;
            }
            while(Character.isWhitespace(sentence[i])) {
                i++;
            }

            j = i + 1;
            while(j < sentence.length && !Character.isWhitespace(sentence[j])) {
                j++;
            }

            stringReverse(sentence, i, j - 1);
            i = j;
        }
        return String.valueOf(sentence);
    }

    public static void stringReverse(char[] str, int start, int end) {
        if (str == null || str.length == 0) {
            return;
        }
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
