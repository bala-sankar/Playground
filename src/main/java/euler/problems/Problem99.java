package euler.problems;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 11/15/12
 */
public class Problem99 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        FileInputStream fileStream;
        double maxValue = 0;
        long lineMax = 0;
        try {
            fileStream = new FileInputStream("src/main/resources/base_exp.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line;
            long lineNumber = 1;
            while ((line = bufferedReader.readLine()) != null) {
                //Assumption the lines has only two values separated by comma
                String[] baseExp = line.split(",");
                double value = Math.log(Double.valueOf(baseExp[0])) * Double.valueOf(baseExp[1]);
                if (value > maxValue) {
                    //System.out.println("New max : " + lineNumber);
                    lineMax = lineNumber;
                    maxValue = value;
                }
                lineNumber++;
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineMax;
    }
}
