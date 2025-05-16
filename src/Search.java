import java.util.*;

public abstract class Search<T> {
    protected Graph<T> graph;                      // Uses a common Graph interface
    protected Vertex<T> startVertex;              // The initial vertex
    protected Set<Vertex<T>> marked;              // To track visited vertices
    protected Map<Vertex<T>, Vertex<T>> edgeTo;   // To store the path

    public Search(Graph<T> graph, T startData) {
        this.graph = graph;
        this.startVertex = graph.getVertex(startData);
        if (this.startVertex == null) {
            throw new IllegalArgumentException("Start vertex not found in the graph.");
        }
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public abstract List<T> pathTo(T destination); // An abstract method for finding a path

    public boolean hasPathTo(T destination) {
        Vertex<T> vertex = graph.getVertex(destination);
        return marked.contains(vertex);
    }
}