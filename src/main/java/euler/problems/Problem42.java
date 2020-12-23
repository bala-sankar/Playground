package euler.problems;

import euler.utils.Util;

import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/9/12
 */
public class Problem42 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        TreeSet<Long> triangleNums = Util.getTriangleNumbersByCount(1000);
        HashSet<String> triangleWords = new HashSet<String>();
        FileInputStream fileStream;
        try {
            fileStream = new FileInputStream("src/main/resources/words.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line = bufferedReader.readLine();
            if (null != line) {
                String[] words = line.split(",");
                dataStream.close();

                for (String word : words) {
                    StringBuilder tempName = new StringBuilder(word);
                    tempName.deleteCharAt(0);
                    tempName.deleteCharAt(tempName.length() - 1);
                    long score = 0;
                    for (int i = 0; i < tempName.length(); i++) {
                        //Assuming the names contains only A-Z
                        score = score + (tempName.charAt(i) % 'A') + 1;
                    }
                    if (score > triangleNums.last()) {
                        System.out.println(word + "\t" + score);
                    }
                    if (triangleNums.contains(Long.valueOf(score))) {
                        triangleWords.add(word);
                    }
                }
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return triangleWords.size();
    }
}
