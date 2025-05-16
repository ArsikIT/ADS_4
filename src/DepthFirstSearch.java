import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(UnweightedGraph<T> graph, T startData) {
        super(graph, startData);
        dfs(graph, startData);
    }

    private void dfs(UnweightedGraph<T> graph, T current) {
        Vertex<T> currentVertex = graph.getVertex(current);
        marked.add(currentVertex);

        for (Vertex<T> neighbor : graph.adjacencyList(current)) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, currentVertex);
                dfs(graph, neighbor.getData());
            }
        }
    }

    @Override
    public List<T> pathTo(T destination) {
        List<T> path = new ArrayList<>();
        Vertex<T> current = graph.getVertex(destination);

        if (!marked.contains(current)) {
            return path; // Путь отсутствует
        }

        while (current != null) {
            path.add(current.getData());
            current = edgeTo.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}