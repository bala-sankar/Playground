package euler.problems;

import euler.utils.cards.CardPack;
import euler.utils.cards.PokerHand;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/1/12
 */
public class Problem54 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int count = 0;
        FileInputStream fileStream;
        try {
            TreeMap<String, CardPack.Card> map = new CardPack().getMap();
            fileStream = new FileInputStream("src/main/resources/poker.txt");
            DataInputStream dataStream = new DataInputStream(fileStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line;

            //int lineNum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                //lineNum++;

                ArrayList<CardPack.Card> temp1 = new ArrayList<CardPack.Card>();
                ArrayList<CardPack.Card> temp2 = new ArrayList<CardPack.Card>();
                String[] cards = line.split(" ");
                temp1.add(map.get(cards[0]));
                temp1.add(map.get(cards[1]));
                temp1.add(map.get(cards[2]));
                temp1.add(map.get(cards[3]));
                temp1.add(map.get(cards[4]));
                PokerHand player1 = new PokerHand(temp1);

                temp2.add(map.get(cards[5]));
                temp2.add(map.get(cards[6]));
                temp2.add(map.get(cards[7]));
                temp2.add(map.get(cards[8]));
                temp2.add(map.get(cards[9]));
                PokerHand player2 = new PokerHand(temp2);
                if (player1.isWinner(player2)) {
                    count++;
                    /*System.out.println("**********");
                    System.out.println("line : " + lineNum);
                    System.out.println("**********");
                    System.out.println(cards[0] + " " + cards[1] + " " + cards[2] + " " + cards[3] + " " + cards[4]);
                    System.out.println(player1.toString());
                    System.out.println(cards[5] + " " + cards[6] + " " + cards[7] + " " + cards[8] + " " + cards[9]);
                    System.out.println(player2.toString());*/
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
        return count;
    }
}
