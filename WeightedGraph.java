import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> map = new HashMap<>();

    public WeightedGraph() {
        this(true);
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }






    public void addVertex(T v) {
        if (hasVertex(v))
            return;

        map.put(v, new Vertex<>(v));
    }

    public void addEdge(T source, T dest, double weight) {


        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);

        Vertex<T> s = map.get(source);
        Vertex<T> d = map.get(dest);

        if (source.equals(dest) || s.contains(d)) return;

        // Use a single, clear method
        s.addAdjacent(d, weight);

        if (undirected) {
            d.addAdjacent(s, weight);
        }
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;

        return map.get(source).contains(new Vertex<T>(dest));
    }

    public List<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;

        List<T> neighborsData = new LinkedList<>();

        Vertex<T> currentVertex = map.get(v);

        return currentVertex.adjacencyList();
    }

    public Iterable<T> getEdges(T v) {
        if (!hasVertex(v)) return null;
        Vertex<T> vertex = map.get(v);
        return vertex.adjacencyList();

    }
    // Add this to WeightedGraph.java
    public Vertex<T> getVertex(T data) {
        return map.get(data);
    }
}
