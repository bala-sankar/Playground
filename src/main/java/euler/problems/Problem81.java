package euler.problems;

import euler.utils.Util;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/25/12
 */
public class Problem81 {
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

            while ((line = bufferedReader.readLine()) != null) {

                String[] elements = line.split(",");
                for (column = 0; column < elements.length; column++) {
                    String v = row + "~" + column;

                    if (!matrix.containsVertex(v)) {
                        matrix.addVertex(v);
                    }
                    if (row == 0 && column == 0) {
                        matrix.addVertex("root");
                        matrix.setEdgeWeight(matrix.addEdge("root", v), Double.parseDouble(elements[column]));
                    }
                    if (row - 1 >= 0) {
                        String vUp = (row - 1) + "~" + column;
                        if (matrix.containsVertex(vUp)) {
                            matrix.setEdgeWeight(matrix.addEdge(vUp, v), Double.parseDouble(elements[column]));
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
            String target = (row - 1) + "~" + (column - 1);
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
            return Util.dijkstra(matrix, "root", target, 0);
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
