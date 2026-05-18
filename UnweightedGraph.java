import java.util.*;

public class UnweightedGraph<T> {
    private final boolean undirected;
    private final Map<T, Vertex<T>> map = new HashMap<>();

    public UnweightedGraph()
    {
        this(true);
    }

    public UnweightedGraph(boolean undirected) {

        this.undirected = undirected;
    }

    public void addVertex(T v) {
        if (hasVertex(v))
            return;

        map.put(v, new Vertex<T>(v));
    }

    public void addEdge(T source, T dest) { // starting and end point
        if (!hasVertex(source))
            addVertex(source); // adds when False->true-- as it is missing value

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

// Logic: Get the source vertex and add the destination vertex to its map
        map.get(source).add(map.get(dest));

        if (undirected)
            map.get(dest).add(map.get(source));
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
        if (!hasVertex(source) || !hasVertex(dest)) return false;

        return map.get(source).contains(map.get(dest));
    }

    public List<T> adjacencyList(T v) {
        if (!hasVertex(v)) return null;

        return map.get(v).adjacencyList();
    }
}

