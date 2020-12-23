package euler.problems;

import euler.utils.Util;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/27/12
 */
public class Problem82 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        FileInputStream fileStream;
        DataInputStream dataStream;
        BufferedReader bufferedReader;
        try {
            fileStream = new FileInputStream("src/main/resources/matrix.txt");
            dataStream = new DataInputStream(fileStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line;

            //Create a directed graph
            SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> matrix =
                    new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
            int row = 0, column = 0;
            ArrayList<String> targets = new ArrayList<String>();
            ArrayList<String> sources = new ArrayList<String>();
            HashMap<String, Long> weights = new HashMap<String, Long>();
            while ((line = bufferedReader.readLine()) != null) {

                String[] elements = line.split(",");
                for (column = 0; column < elements.length; column++) {
                    String v = row + "~" + column;
                    weights.put(v, Long.parseLong(elements[column]));
                    if (!matrix.containsVertex(v)) {
                        matrix.addVertex(v);
                    }

                    if (row - 1 >= 0) {
                        String vUp = (row - 1) + "~" + column;
                        if (matrix.containsVertex(vUp)) {
                            matrix.setEdgeWeight(matrix.addEdge(vUp, v), Double.parseDouble(elements[column]));
                            matrix.setEdgeWeight(matrix.addEdge(v, vUp), weights.get(vUp));
                        }
                    }
                    if (column - 1 >= 0) {
                        String vLeft = row + "~" + (column - 1);
                        if (matrix.containsVertex(vLeft)) {
                            matrix.setEdgeWeight(matrix.addEdge(vLeft, v), Double.parseDouble(elements[column]));
                        }
                    }
                }
                row++;
            }

            for (int i = 0; i < row; i++) {
                sources.add(i + "~0");
                targets.add(i + "~" + (column - 1));
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
            return Util.minDistInGraph(matrix, weights, sources, targets);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
