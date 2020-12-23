package euler.problems;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/15/11
 */
public class Problem22 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long OverallScore = 0;
        try {

            FileInputStream fileStream = new FileInputStream("src/main/resources/names.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] names = line.split(",");
                dataStream.close();
                TreeMap<String, Integer> nameScores = new TreeMap<String, Integer>();
                for (String name : names) {
                    StringBuilder tempName = new StringBuilder(name);
                    tempName.deleteCharAt(0);
                    tempName.deleteCharAt(tempName.length() - 1);
                    int score = 0;
                    for (int i = 0; i < tempName.length(); i++) {
                        //Assuming the names contains only A-Z
                        score = score + (tempName.charAt(i) % 'A') + 1;
                    }
                    nameScores.put(tempName.toString(), score);
                }
                int pos = 0;
                for (Map.Entry<String, Integer> entry : nameScores.entrySet()) {
                    pos++;
                    OverallScore = OverallScore + pos * entry.getValue();
                }
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return OverallScore;
    }
}
