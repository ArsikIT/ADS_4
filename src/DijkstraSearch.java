import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private Map<Vertex<T>, Double> distances; // Stores the distances from the starting vertex

    public DijkstraSearch(WeightedGraph<T> graph, T startData) {
        super(graph, startData); // Calling the parent's constructor
        distances = new HashMap<>();
        distances.put(startVertex, 0.0); // The initial vertex has a distance of 0
    }

    @Override
    public List<T> pathTo(T destination) {
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        pq.add(startVertex);
        marked.add(startVertex);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();
            if (current.getData().equals(destination)) {
                break;
            }

            for (Edge<T> edge : current.getEdges()) {
                Vertex<T> neighbor = edge.getDestination();
                double newDist = distances.getOrDefault(current, Double.MAX_VALUE) + edge.getWeight();
                if (!marked.contains(neighbor) || newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        List<T> resultPath = new ArrayList<>();
        Vertex<T> current = graph.getVertex(destination);
        if (distances.containsKey(current)) {
            while (current != null) {
                resultPath.add(current.getData());
                current = edgeTo.get(current);
            }
            Collections.reverse(resultPath);
        }

        return resultPath;
    }
}