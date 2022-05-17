package datastructure.graph;

import java.util.*;

public class WeightedGraph {
    private Map<String, Map<String, Integer>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public Map<String, Map<String, Integer>> getAdjacencyList() {
        return this.adjacencyList;
    }

    // Add Edge
    void addEdgeOrUpdate(String source, String destination, int weight) {
        if(!this.adjacencyList.containsKey(source)) {
            this.adjacencyList.put(source, new HashMap<String, Integer>());
        }
        Map<String, Integer> connections = this.adjacencyList.get(source);
        connections.merge(destination, weight, Integer::sum);
    }
}
