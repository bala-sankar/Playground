package euler.problems;

import euler.utils.romannumber.RomanNumerals;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 11/14/12
 */
public class Problem89 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        FileInputStream fileStream;
        long sum = 0;
        try {
            fileStream = new FileInputStream("src/main/resources/roman.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sum = sum + line.length() - RomanNumerals.getMinimalRomanNumber(line).length();
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
