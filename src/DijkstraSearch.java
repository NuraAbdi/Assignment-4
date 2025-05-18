import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private Map<Vertex<V>, Double> distances;
    private Map<Vertex<V>, Vertex<V>> previousVertices;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        distances = new HashMap<>();
        previousVertices = new HashMap<>();
        dijkstra(graph, startVertex);
    }

    private void dijkstra(WeightedGraph<V> graph, Vertex<V> startVertex) {
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex<V> vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }

        distances.put(startVertex, 0.0);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previousVertices.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> destination) {
        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> current = destination;

        while (current != null) {
            path.add(0, current);
            current = previousVertices.get(current);
        }

        return path;
    }
}
