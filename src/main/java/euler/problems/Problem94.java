package euler.problems;

public class Problem94 {

    public static final long ONE_BILLION = 1000000000;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution3());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long sumOfPerimeter = 0;
        for (long  i = 2; sumOfPerimeter <= ONE_BILLION; i++){
            //perimeter: 3*i - 2;

            double height = Math.sqrt((3*i*i) - (2*i) + 1);
            long perimeter = (3 * i) - 2;
            if(i % 4 == 0.0 && height % 1 == 0){
                System.out.println("Sides: " + i + "," + i + "," + (i+1) + ";\t\tPerimeter: "+ perimeter );
                long tempSumOfPerimeter = sumOfPerimeter + perimeter;
                if(tempSumOfPerimeter <= ONE_BILLION){
                    sumOfPerimeter = tempSumOfPerimeter;
                } else {
                    break;
                }
            }

            //perimeter: 3*i + 2
            height = Math.sqrt((3*i*i) + (2*i) + 1);
            perimeter =  ((3*i)+2);
            if((i+1) % 1 == 0.0){
                System.out.println("Sides: " + i + "," + (i+1) + "," + (i+1) + ";\t\tPerimeter: "+ perimeter );
                long tempSumOfPerimeter = sumOfPerimeter + perimeter;
                if(tempSumOfPerimeter <= ONE_BILLION){
                    sumOfPerimeter = tempSumOfPerimeter;
                } else {
                    break;
                }
            }
        }
        return sumOfPerimeter;
    }

    public static long solution2() {
        long sumOfPerimeter = 0;
        for (long  i = 2; sumOfPerimeter <= ONE_BILLION; i++){
            //n+1
            long x = (i*i) * ((3*i*i)+(2*i)+i);
            if(x % 16 == 0){
                x = x/16;
                double area = Math.sqrt(x);
                if(area * area == (double) x){
                    sumOfPerimeter += ((3*i)+2);
                }
            }

            //n-1
            long y =(i*i) * ((3*i*i)-(2*i)+i);
            if(y % 16 == 0){
                y = y/16;
                double area = Math.sqrt(y);
                if(area * area == (double) y){
                    sumOfPerimeter += ((3*i)-2);
                }
            }

        }
        return sumOfPerimeter;
    }

    // Pell's equation
    // Thanks to - http://www.mathblog.dk/project-euler-94-almost-equilateral-triangles/
    public static long solution3() {
        long sumOfPerimeter = 0;
        return 0;
    }

//    private static double area (long x, long y) {
//        BigDecimal a = new BigDecimal(x);
//        BigDecimal b = new BigDecimal(y);
//        b.divide(a)
//        a.multiply(a).multiply(BigDecimal.valueOf(0.5)).multiply();
//        double secondPart = (b * 1.0) / (a * 1.0);
//        double thirdPart = Math.sqrt(secondPart * secondPart - 0.25);
//        return firstPart * thirdPart;
//    }
}
