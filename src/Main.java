public class Main {

    public static void main(String[] args) {
        // Create a weighted graph
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        // Run Dijkstra algorithm
        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        // Create an unweighted graph
        UnweightedGraph<String> unweightedGraph = new UnweightedGraph<>(true);
        fillWithoutWeights(unweightedGraph);

        // Run BFS on unweighted graph
        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(unweightedGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");

        System.out.println("--------------------------------");

        // Run DFS on unweighted graph
        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(unweightedGraph, "Almaty");
        outputPath(dfs, "Kyzylorda");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        // First, add all the vertices
        graph.addVertex("Almaty");
        graph.addVertex("Astana");
        graph.addVertex("Shymkent");
        graph.addVertex("Atyrau");
        graph.addVertex("Kostanay");
        graph.addVertex("Kyzylorda");

        // Add weighted edges
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void fillWithoutWeights(UnweightedGraph<String> graph) {
        // First, add all the vertices
        graph.addVertex("Almaty");
        graph.addVertex("Astana");
        graph.addVertex("Shymkent");
        graph.addVertex("Atyrau");
        graph.addVertex("Kostanay");
        graph.addVertex("Kyzylorda");

        // Add unweighted edges
        graph.addEdge("Almaty", "Astana");
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println();
    }
}
