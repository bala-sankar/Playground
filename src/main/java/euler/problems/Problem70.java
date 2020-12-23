package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 6/4/12
 */
public class Problem70 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long nLimit = 10000000;
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit((long) Math.sqrt((double) nLimit));
        long start = 2;
        long end = nLimit / 10;
        long batchSize = 1000000;
        Thread[] queue = new Thread[10];
        for (int batch = 0; batch < 10; batch++) {
            Problem70Util temp = new Problem70Util(start, end, primeNums);
            queue[batch] = new Thread(temp);
            queue[batch].start();
            start = end + 1;
            end = end + batchSize;
        }
        for (int batch = 0; batch < 10; batch++) {
            try {
                queue[batch].join();
                //System.out.println("Thread Joined");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Problem70Util.getSharedMinN();
    }
}

class Problem70Util implements Runnable {
    private long limitStart;
    private long limitEnd;
    private TreeSet<Long> primeNums;
    private static long sharedMinN = 0;
    private static double sharedMinNByPhi = Double.MAX_VALUE;

    Problem70Util(long limitStart, long limitEnd, TreeSet<Long> primeNums) {
        this.limitEnd = limitEnd;
        this.limitStart = limitStart;
        this.primeNums = primeNums;
    }

    public synchronized static long getSharedMinN() {
        return sharedMinN;
    }

    public void run() {
        //System.out.println("Thread Execution started");
        double minNByPhi = Double.MAX_VALUE;
        long minN = 0;
        for (long n = limitStart; n < limitEnd; n++) {
            double nByPhi;
            double phi = Util.phiFunction(n, primeNums);
            nByPhi = (double) n / phi;
            if (nByPhi < minNByPhi) {
                String num = Util.getSortedDigitsAsString(n);
                String phiNum = Util.getSortedDigitsAsString((long) phi);
                if (num.equals(phiNum)) {
                    //System.out.println(n + "~" + (long) phi + "~" + nByPhi);
                    minNByPhi = nByPhi;
                    minN = n;
                }
            }
        }
        checkMinNByPhi(minN, minNByPhi);
    }

    private synchronized void checkMinNByPhi(long minN, double minNByPhi) {
        if (minNByPhi < sharedMinNByPhi) {
            sharedMinNByPhi = minNByPhi;
            sharedMinN = minN;
        }
    }
}


