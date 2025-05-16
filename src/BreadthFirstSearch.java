import java.util.*;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(UnweightedGraph<T> graph, T startData) {
        super(graph, startData);
        bfs(graph, startData);
    }

    private void bfs(UnweightedGraph<T> graph, T current) {
        Vertex<T> currentVertex = graph.getVertex(current);
        marked.add(currentVertex);

        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(currentVertex);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();

            for (Vertex<T> vertex : graph.adjacencyList(v.getData())) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }

    @Override
    public List<T> pathTo(T destination) {
        List<T> path = new ArrayList<>();
        Vertex<T> current = graph.getVertex(destination);

        if (!marked.contains(current)) {
            return path; // No path found
        }

        while (current != null) {
            path.add(current.getData());
            current = edgeTo.get(current);
        }
        Collections.reverse(path);
        return path;
    }
}