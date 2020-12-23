package euler.problems;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/19/12
 */
public class Problem79 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    //Assumption : There is no repetition or loop; say something like *121*
    public static long solution1() {
        StringBuilder result = new StringBuilder();
        FileInputStream fileStream;
        DataInputStream dataStream;
        BufferedReader bufferedReader;
        try {
            fileStream = new FileInputStream("src/main/resources/keylog.txt");
            dataStream = new DataInputStream(fileStream);
            bufferedReader = new BufferedReader(new InputStreamReader(dataStream, "UTF-8"));
            String line;

            //Create a directed graph
            DirectedGraph<Integer, DefaultEdge> passcodeGraph =
                    new DefaultDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);
            while ((line = bufferedReader.readLine()) != null) {
                int value = Integer.parseInt(line);
                int v1 = value / 100;
                int v2 = (value / 10) % 10;
                int v3 = value % 10;
                if (!passcodeGraph.containsVertex(v1)) {
                    passcodeGraph.addVertex(v1);
                }
                if (!passcodeGraph.containsVertex(v2)) {
                    passcodeGraph.addVertex(v2);
                }
                if (!passcodeGraph.containsVertex(v3)) {
                    passcodeGraph.addVertex(v3);
                }
                if (!passcodeGraph.containsEdge(v1, v2)) {
                    passcodeGraph.addEdge(v1, v2);
                }
                if (!passcodeGraph.containsEdge(v2, v3)) {
                    passcodeGraph.addEdge(v2, v3);
                }
            }

            //Find the vertex which has 0 incoming edges, add it to the result and remove it.
            int loop = passcodeGraph.vertexSet().size();
            for (int i = 0; i < loop; i++) {
                int vertexToRemove = -1;
                for (int v : passcodeGraph.vertexSet()) {
                    if (passcodeGraph.incomingEdgesOf(v).size() == 0) {
                        vertexToRemove = v;
                        break;
                    }
                }
                result.append(vertexToRemove);
                passcodeGraph.removeVertex(vertexToRemove);
            }
            bufferedReader.close();
            dataStream.close();
            fileStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.length() == 0) {
            return 0;
        }
        return Long.valueOf(result.toString());
    }
}
