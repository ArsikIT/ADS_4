import java.util.*;

public class WeightedGraph<T> implements Graph<T> {
    private final boolean directed;                  // Указывает, направленный граф или нет
    private final Map<T, Vertex<T>> vertices;       // Хранит вершины

    public WeightedGraph(boolean directed) {
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
        return vertices.get(data); // Возвращает вершину
    }

    @Override
    public boolean hasVertex(T data) {
        return vertices.containsKey(data); // Проверяет наличие вершины
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

        sourceVertex.addEdge(destinationVertex, weight); // Добавляет ребро
        if (!directed) {
            destinationVertex.addEdge(sourceVertex, weight); // Для ненаправленных графов
        }
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values(); // Возвращает все вершины
    }
}