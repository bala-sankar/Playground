package euler.problems;

import datastructure.queue.Deque;
import datastructure.queue.DequeImpl;

public class Palindrome {
    public static boolean check(String word) {
        char[] letters = word.toCharArray();
        Deque<Character> charDeque = new DequeImpl<Character>();
        for (char letter : letters) {
            charDeque.addRear(letter);
        }

        while (charDeque.size() > 1) {
            Character front = charDeque.removeFront();
            Character rear = charDeque.removeRear();
            if (front != rear) {
                return false;
            }
        }
        return true;
    }
}
