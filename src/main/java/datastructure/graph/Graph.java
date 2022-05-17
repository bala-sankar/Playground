package datastructure.graph;

import java.util.*;

public class Graph {
    private Map<String, LinkedList<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public Map<String, LinkedList<String>> getAdjacencyList() {
        return this.adjacencyList;
    }

    // Add Edge
    // Incomplete
    void addEdgeOrUpdate(String source, String destination) {
        if(!this.adjacencyList.containsKey(source)) {
            this.adjacencyList.put(source, new LinkedList<>());
        }
//        Map<String, Integer> connections = this.adjacencyList.get(source);
//        connections.merge(destination, weight, Integer::sum);
    }
}
