import java.util.*;

public abstract class Search<T> {
    protected Graph<T> graph;                      // Использует общий интерфейс Graph
    protected Vertex<T> startVertex;              // Начальная вершина
    protected Set<Vertex<T>> marked;              // Для отслеживания посещенных вершин
    protected Map<Vertex<T>, Vertex<T>> edgeTo;   // Для хранения пути

    public Search(Graph<T> graph, T startData) {
        this.graph = graph;
        this.startVertex = graph.getVertex(startData);
        if (this.startVertex == null) {
            throw new IllegalArgumentException("Start vertex not found in the graph.");
        }
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public abstract List<T> pathTo(T destination); // Абстрактный метод для нахождения пути

    public boolean hasPathTo(T destination) {
        Vertex<T> vertex = graph.getVertex(destination);
        return marked.contains(vertex);
    }
}