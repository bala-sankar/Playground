package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;

public class Problem90 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("6"); //Substitute for 9
        numbers.add("7");
        numbers.add("8");


        ArrayList<String> combinations = Util.getCombination(numbers, 6);
        long count = 0;
        for (String dice1 : combinations) {
            boolean dice1Has0 = dice1.contains("0");
            boolean dice1Has1 = dice1.contains("1");
            boolean dice1Has2 = dice1.contains("2");
            boolean dice1Has3 = dice1.contains("3");
            boolean dice1Has4 = dice1.contains("4");
            boolean dice1Has5 = dice1.contains("5");
            boolean dice1Has6 = dice1.contains("6");
            boolean dice1Has8 = dice1.contains("8");
            if (!(dice1.startsWith("0") || dice1.startsWith("1"))) {
                break;
            }

            for (String dice2 : combinations) {
                if (Long.parseLong(dice1) <= Long.parseLong(dice2)) {
                    continue;
                }
                if (!(dice2.startsWith("0") || dice2.startsWith("1"))) {
                    break;
                }
                boolean dice2Has0 = dice2.contains("0");
                boolean dice2Has1 = dice2.contains("1");
                boolean dice2Has2 = dice2.contains("2");
                boolean dice2Has3 = dice2.contains("3");
                boolean dice2Has4 = dice2.contains("4");
                boolean dice2Has5 = dice2.contains("5");
                boolean dice2Has6 = dice2.contains("6");
                boolean dice2Has8 = dice2.contains("8");

                if (((dice1Has0 && dice2Has1) || (dice1Has1 && dice2Has0))
                        && ((dice1Has0 && dice2Has4) || (dice1Has4 && dice2Has0))
                        && ((dice1Has0 && dice2Has6) || (dice1Has6 && dice2Has0))
                        && ((dice1Has1 && dice2Has6) || (dice1Has6 && dice2Has1))
                        && ((dice1Has2 && dice2Has5) || (dice1Has5 && dice2Has2))
                        && ((dice1Has3 && dice2Has6) || (dice1Has6 && dice2Has3))
                        && ((dice1Has4 && dice2Has6) || (dice1Has6 && dice2Has4))
                        && ((dice1Has8 && dice2Has1) || (dice1Has1 && dice2Has8))
                        ) {
                    count++;
                }
            }
        }
        return count;
    }
}

