package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/13/11
 */
public class Problem19 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        /*
         * Assumption
         * 0 => "Sunday",
         * 1 => "Monday",
         * 2 => "Tuesday",
         * 3 => "Wednesday",
         * 4 => "Thursday",
         * 5 => "Friday",
         * 6 => "Saturday"};
         * */
        //Since Jan 1st 1900 is monday, Set start day to 1;
        int startDay = 1;
        //Calculate the first day of year 1901
        for (int days : GetMonthDays(1900)) {
            startDay = startDay + days;
        }
        startDay = startDay % 7;
        int numberOfSundays = 0;
        //If Jan 1st of 1901 is Sunday, then add it
        if (startDay == 0) {
            numberOfSundays++;
        }
        for (int year = 1901; year <= 2000; year++) {
            int[] monthDays = GetMonthDays(year);
            for (int month = 0; month < 12; month++) {
                startDay = startDay + monthDays[month];
                startDay = startDay % 7;
                if (startDay == 0) {
                    numberOfSundays++;
                }
            }
        }
        //If Jan 1st of 2001 is Sunday, then remove it
        if (startDay == 0) {
            numberOfSundays--;
        }
        return numberOfSundays;
    }

    private static int[] GetMonthDays(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else {
            return new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }
    }
}
