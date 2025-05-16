import java.util.*;

public class WeightedGraph<T> implements Graph<T> {
    private final boolean directed;                  // Indicates whether the graph is directed or not
    private final Map<T, Vertex<T>> vertices;       // Stores vertices

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    @Override
    public void addVertex(T data) {
        if (!vertices.containsKey(data)) {
            vertices.put(data, new Vertex<>(data)); // Creates a new vertex
        }
    }

    @Override
    public Vertex<T> getVertex(T data) {
        return vertices.get(data); // Returns a vertex
    }

    @Override
    public boolean hasVertex(T data) {
        return vertices.containsKey(data); // Checks for the presence of a vertex
    }

    @Override
    public List<Vertex<T>> adjacencyList(T data) {
        return List.of();
    }

    public void addEdge(T source, T destination, double weight) {
        Vertex<T> sourceVertex = vertices.get(source);
        Vertex<T> destinationVertex = vertices.get(destination);

        if (sourceVertex == null || destinationVertex == null) {
            throw new IllegalArgumentException("Source or Destination vertex not found in the graph.");
        }

        sourceVertex.addEdge(destinationVertex, weight); // Adds an edge
        if (!directed) {
            destinationVertex.addEdge(sourceVertex, weight); // For undirected graphs
        }
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values(); // Returns all vertices
    }
}