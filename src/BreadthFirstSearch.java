import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<Vertex<V>, Vertex<V>> parentMap;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> startVertex) {
        parentMap = new HashMap<>();
        bfs(graph, startVertex);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> startVertex) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);
        parentMap.put(startVertex, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public List<Vertex<V>> getPath(Vertex<V> destination) {
        List<Vertex<V>> path = new LinkedList<>();
        Vertex<V> current = destination;

        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }

        return path;
    }
}
