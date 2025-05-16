import java.util.*;

public class UnweightedGraph<T> implements Graph<T> {
    private final boolean directed;                  // Указывает, направленный граф или нет
    private final Map<T, Vertex<T>> vertices;       // Хранит вершины

    public UnweightedGraph(boolean directed) {
        this.directed = directed;
        this.vertices = new HashMap<>();
    }

    @Override
    public void addVertex(T data) {
        if (!vertices.containsKey(data)) {
            vertices.put(data, new Vertex<>(data)); // Создает новую вершину
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

    public void addEdge(T source, T destination) {
        Vertex<T> sourceVertex = vertices.get(source);
        Vertex<T> destinationVertex = vertices.get(destination);

        if (sourceVertex == null || destinationVertex == null) {
            throw new IllegalArgumentException("Source or Destination vertex not found in the graph.");
        }

        sourceVertex.addEdge(destinationVertex, 0); // The default weight is 0
        if (!directed) {
            destinationVertex.addEdge(sourceVertex, 0); // For undirected graphs
        }
    }

    @Override
    public List<Vertex<T>> adjacencyList(T data) {
        Vertex<T> vertex = vertices.get(data);
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex not found in the graph.");
        }
        return vertex.getAdjacentVertices();
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values(); // Returns all vertices
    }
}