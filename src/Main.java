public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(b, d, 5);
        graph.addEdge(c, d, 1);

        Search<String> bfs = new BreadthFirstSearch<>(graph, a);
        System.out.println("BFS path from A to D: " + bfs.getPath(d));

        Search<String> dijkstra = new DijkstraSearch<>(graph, a);
        System.out.println("Dijkstra path from A to D: " + dijkstra.getPath(d));
    }
}
