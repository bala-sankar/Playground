package euler.problems;

import euler.utils.Util;
import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 4/12/12
 */
public class Problem66 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution3());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution3() {
        long resultD = 0;
        BigInteger largeX = BigInteger.ZERO;
        for (int d = 2; d <= 1000; d++) {
            double sqrtD = Math.sqrt((double) d);
            if ((double) (long) sqrtD == sqrtD) {
                continue;
            }

            String[] continuedFraction = Util.getContinuedFractions(d).split(";");
            int a0 = Integer.parseInt(continuedFraction[0]);
            String[] periods = continuedFraction[1].split(",");
            int term = 0;
            BigInteger D = new BigInteger(String.valueOf(d));

            while (true) {
                BigFraction temp = Util.getConvergent(term, periods, a0);
                BigInteger x2 = temp.getNumerator().multiply(temp.getNumerator());
                BigInteger y2 = temp.getDenominator().multiply(temp.getDenominator());
                BigInteger result = x2.subtract(y2.multiply(D));
                if (result.equals(BigInteger.ONE)) {
                    //System.out.println(d+"~"+temp.getNumerator().toString()+"~"+temp.getDenominator().toString());
                    if (temp.getNumerator().compareTo(largeX) > 0) {
                        largeX = temp.getNumerator();
                        resultD = d;
                    }

                    break;
                }
                term++;
            }
        }
        return resultD;
    }
    /*public static long solution1() {
        long largeX = 0;
        long resultD = 0;
        for (int d = 2; d <= 13; d++) {
            double sqrtD = Math.sqrt((double) d);
            if ((double) (long) sqrtD == sqrtD) continue;
            BigInteger D = new BigInteger(String.valueOf(d));
            for (int y = 1; ; y++) {
                BigInteger Y = new BigInteger(String.valueOf(y));
                BigInteger temp = (((Y.multiply(Y)).multiply(D)).add(BigInteger.ONE));
                String dxTemp = Util.sqrtForBigNum(temp.toString());
                double diophantineX = Double.valueOf(dxTemp);

                if (diophantineX < 0) {
                    System.out.println("We have an issue");
                }
                if ((double) (long) diophantineX == diophantineX) {
                    if (largeX <= (long) diophantineX) {
                        largeX = (long) diophantineX;
                        resultD = d;
                    }
                    BigInteger X = new BigInteger(String.valueOf((long) diophantineX));
                    BigInteger one = (X.multiply(X)).subtract((Y.multiply(Y)).multiply(D));
                    //if(!one.equals(BigInteger.ONE)){
                    //System.out.println(dxTemp);
                    System.out.println((int) diophantineX + "^2-" + d + "*" + y + "^2");
                    //}
                    break;
                }
                if (y == 1000) {
                    //System.out.println("We have an issue");
                }
            }
        }
        return resultD;
    }

    public static long Solution2() {
        HashMap<String, Long> xMap = new HashMap<String, Long>();
        long largeX = 0, resultD = 0;
        *//*for(long x = 2; x<1000 ; x++){
            BigInteger t1 = new BigInteger(String.valueOf(x-1));
            BigInteger t2 = new BigInteger(String.valueOf(x+1));
            xMap.put(t1.multiply(t2).toString(), x);
        }*//*

        for (int d = 2; d <= 100; d++) {
            double sqrtD = Math.sqrt((double) d);
            if ((double) (long) sqrtD == sqrtD) continue;

            BigInteger D = new BigInteger(String.valueOf(d));
            for (long y = 2; ; y++) {

                BigInteger Y = new BigInteger(String.valueOf(y));
                BigInteger xSqr = (((Y.multiply(Y)).multiply(D)).add(BigInteger.ONE));
                String numerator = xSqr.toString();
                if (numerator.endsWith("0") ||
                        numerator.endsWith("1") ||
                        numerator.endsWith("4") ||
                        numerator.endsWith("9") ||
                        numerator.endsWith("6"))

                {
                    String sqrt = euler.utils.Util.sqrtForBigNum(numerator);
                    String[] parts = sqrt.split("\\.");
                    long remainder = Long.parseLong(parts[1]);
                    if (remainder == 0) {
                        long x = Long.parseLong(parts[0]);
                        System.out.println(d + "~" + x + "~" + y);
                        if (x > largeX) {
                            largeX = x;
                            resultD = d;
                        }
                        break;
                    }
                }

                if (y == Long.MAX_VALUE) {
                    System.out.println(d);
                    System.out.println("We have an issue");
                    break;
                }
            }
        }
        return resultD;
    }*/
}
