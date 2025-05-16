import java.util.List;

public interface Graph<T> {
    Vertex<T> getVertex(T data);
    void addVertex(T data);
    boolean hasVertex(T data);
    List<Vertex<T>> adjacencyList(T data);
}