package euler.problems;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/13/12
 */
public class Problem59 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        FileInputStream fileStream;
        try {
            fileStream = new FileInputStream("src/main/resources/cipher1.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line;
            line = bufferedReader.readLine();
            if (line != null) {
                String[] letters = line.split(",");

                ArrayList<String> encryptKeyChars = new ArrayList<String>();
                for (char i = 'a'; i <= 'z'; i++) {
                    encryptKeyChars.add(String.valueOf(i));
                }
                ArrayList<String> possibleEncryptKeys = euler.utils.Util.getPermutationsWithRepetition(encryptKeyChars, 3);
                boolean isDecrypted;
                for (String encryptKey : possibleEncryptKeys) {
                    //encryptKey = "god";
                    char[] keyChars = encryptKey.toCharArray();
                    ArrayList<Character> origChars = new ArrayList<Character>();
                    int j = 0;
                    isDecrypted = true;
                    for (String singleChar : letters) {
                        char c = (char) (Integer.valueOf(singleChar) ^ keyChars[j % 3]);
                        //Possible valid chars
                        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                                || c == ',' || c == '"' || c == '\'' || c == '.'
                                || c == '?' || c == '&' || c == '(' || c == ')' || c == '!'
                                || c == ';' || c == ':' || c == '-' || c == ' '
                                || (c >= '0' && c <= '9')) {
                            origChars.add(c);
                        } else {
                            isDecrypted = false;
                            break;
                        }
                        j++;
                    }
                    if (isDecrypted) {
                        long sum = 0;
                        StringBuilder message = new StringBuilder();
                        for (char x : origChars) {
                            message.append(x);
                            sum = sum + x;
                        }
                        bufferedReader.close();
                        dataStream.close();
                        fileStream.close();
                        return sum;
                        //System.out.println(encryptKey +"\t" +sum +"\t"+ message);
                    }
                }
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
