package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/15/12
 */
public class Problem61 {
    private HashMap<Long, ArrayList<PolygonalNumber>> startsWithList = new HashMap<Long, ArrayList<PolygonalNumber>>();
    //private HashMap<Long, ArrayList<PolygonalNumber>> endsWithList= new HashMap<Long, ArrayList<PolygonalNumber>>();
    private HashSet<PolygonalNumber> polygonalNumbers = new HashSet<PolygonalNumber>();
    private long firstTwoDigits = 0;
    private static final int LIMIT = 10000;
    private static final int TRIM_VALUE = 1000;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + new Problem61().solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public long solution1() {
        TreeSet<Long> p8 = Util.getOctagonalNumbersByLimit(LIMIT);
        trimValuesLessThan(p8, TRIM_VALUE);
        populateStartsWithAndPolygonalList(p8, 8);

        TreeSet<Long> p7 = Util.getHeptagonalNumbersByLimit(LIMIT);
        trimValuesLessThan(p7, TRIM_VALUE);
        populateStartsWithAndPolygonalList(p7, 7);

        TreeSet<Long> p6 = Util.getHexagonalNumbersByLimit(LIMIT);
        trimValuesLessThan(p6, TRIM_VALUE);
        populateStartsWithAndPolygonalList(p6, 6);

        TreeSet<Long> p5 = Util.getPentagonalNumbersByLimit(LIMIT);
        trimValuesLessThan(p5, TRIM_VALUE);
        populateStartsWithAndPolygonalList(p5, 5);

        TreeSet<Long> p4 = Util.getSquareNumbersByLimit(LIMIT);
        trimValuesLessThan(p4, TRIM_VALUE);
        populateStartsWithAndPolygonalList(p4, 4);

        TreeSet<Long> p3 = Util.getTriangleNumbersByLimit(LIMIT);
        trimValuesLessThan(p3, TRIM_VALUE);
        populateStartsWithAndPolygonalList(p3, 3);


        long sum = 0;
        HashSet<Long> types = new HashSet<Long>();
        for (PolygonalNumber num : polygonalNumbers) {
            types.add(num.getType());
            firstTwoDigits = num.getNum() / 100;
            sum = cyclicPolygonal(num.getNum(), types, num.getNum());
            types.remove(num.getType());
            if (sum != 0) {
                break;
            }
        }

        return sum;
    }

    private long cyclicPolygonal(long num, HashSet<Long> types, long sum) {
        /*for(int i = 0 ; i < types.size(); i++){
         System.out.print(" ");
     }
    System.out.println(types.size() + "." + num+"-"+tempType);*/

        long endsWith = num % 100;
        //long endsWith = num / 100;
        long tempSum;
        if (types.size() == 6) {
            if (firstTwoDigits == endsWith) {
                return sum;
            }
            return 0;
        }
        if (startsWithList.containsKey(Long.valueOf(endsWith))) {
            ArrayList<PolygonalNumber> temp = startsWithList.get(Long.valueOf(endsWith));
            for (PolygonalNumber pNum : temp) {
                if (!types.contains(Long.valueOf(pNum.getType()))) {
                    types.add(pNum.getType());
                    tempSum = cyclicPolygonal(pNum.getNum(), types, sum + pNum.getNum());
                    if (tempSum != 0) {
                        return tempSum;
                    }
                    types.remove(pNum.getType());
                }
            }
        }
        return 0;
    }

    private void populateStartsWithAndPolygonalList(TreeSet<Long> p,
                                                    long numType) {
        for (Long num : p) {
            polygonalNumbers.add(new PolygonalNumber(num, numType));
            long startsWithKey = num / 100;
            if (startsWithList.containsKey(Long.valueOf(startsWithKey))) {
                ArrayList<PolygonalNumber> temp = startsWithList.get(Long.valueOf(startsWithKey));
                temp.add(new PolygonalNumber(num, numType));
                startsWithList.put(startsWithKey, temp);
            } else {
                ArrayList<PolygonalNumber> temp = new ArrayList<PolygonalNumber>();
                temp.add(new PolygonalNumber(num, numType));
                startsWithList.put(startsWithKey, temp);
            }
        }
    }

    private static void trimValuesLessThan(TreeSet<Long> p, long value) {
        TreeSet<Long> temp = new TreeSet<Long>();
        temp.addAll(p);
        for (Long num : temp) {
            if (num < value) {
                p.remove(num);
            } else {
                break;
            }
        }
    }

    static class PolygonalNumber {
        private long num;
        private long type;

        PolygonalNumber(long num, long type) {
            this.num = num;
            this.type = type;
        }

        public long getNum() {
            return num;
        }

        public long getType() {
            return type;
        }

        public String toString() {
            return num + "-" + type;
        }
    }
}
