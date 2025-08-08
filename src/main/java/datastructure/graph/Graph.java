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
    
    // Add an edge from source to destination
    public void addEdgeOrUpdate(String source, String destination) {
        this.adjacencyList.computeIfAbsent(source, k -> new LinkedList<>()).add(destination);
        this.adjacencyList.computeIfAbsent(destination, k -> new LinkedList<>()); // Ensure destination exists
    }
    
    // Remove an edge from source to destination
    public void removeEdge(String source, String destination) {
        LinkedList<String> neighbors = this.adjacencyList.get(source);
        if (neighbors != null) {
            neighbors.remove(destination);
        }
    }
    
    // Add a new vertex
    public void addVertex(String vertex) {
        this.adjacencyList.putIfAbsent(vertex, new LinkedList<>());
    }
    
    // Remove a vertex and all its edges
    public void removeVertex(String vertex) {
        this.adjacencyList.remove(vertex);
        for (LinkedList<String> neighbors : this.adjacencyList.values()) {
            neighbors.remove(vertex);
        }
    }
    
    // Check if the graph contains a vertex
    public boolean containsVertex(String vertex) {
        return this.adjacencyList.containsKey(vertex);
    }
    
    // Check if there is an edge from source to destination
    public boolean hasEdge(String source, String destination) {
        LinkedList<String> neighbors = this.adjacencyList.get(source);
        return neighbors != null && neighbors.contains(destination);
    }
    
    // Get all vertices
    public Set<String> getVertices() {
        return this.adjacencyList.keySet();
    }
    
    // Get neighbors of a vertex
    public List<String> getNeighbors(String vertex) {
        return this.adjacencyList.getOrDefault(vertex, new LinkedList<>());
    }

    // Graph traversal using Depth First Search (DFS)
    public void depthFirstSearch(String startVertex) {
        Set<String> visited = new HashSet<>();
        depthFirstSearchHelper(startVertex, visited);
    }

    private void depthFirstSearchHelper(String vertex, Set<String> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (String neighbor : this.adjacencyList.getOrDefault(vertex, new LinkedList<>())) {
            depthFirstSearchHelper(neighbor, visited);
        }
    }
}
