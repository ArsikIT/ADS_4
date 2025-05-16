import java.util.*;

public class Vertex<T> {
private T data;
private List<Edge<T>> edges; // A list of edges coming from this vertex
private int hashCode; // Cached hashCode to improve performance

public Vertex(T data) {
    this.data = data;
    this.edges = new ArrayList<>();
    this.hashCode = (data == null) ? 0 : data.hashCode();
}

public T getData() {
    return data;
}

public List<Vertex<T>> getAdjacentVertices() {
    List<Vertex<T>> adjacent = new ArrayList<>();
    for (Edge<T> edge : edges) {
        adjacent.add(edge.getDestination());
    }
    return adjacent;
}

    public void addEdge(Vertex<T> destination, double weight) {
        edges.add(new Edge<>(this, destination, weight));
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vertex<?> vertex = (Vertex<?>) o;
    return Objects.equals(data, vertex.data);
}

@Override
public int hashCode() {
    return hashCode;
}

@Override
public String toString() {
    return data.toString();
}
}