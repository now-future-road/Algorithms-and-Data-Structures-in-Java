import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class Vertex<T> {
    private T data;

    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;

        adjacentVertices = new HashMap<>();
    }


    public boolean contains(Vertex<T> dest){
        return adjacentVertices.containsKey(dest);
    }
    public List<T> adjacencyList() {
        List<T> list = new LinkedList<>();
        for (Vertex<T> neighbor : adjacentVertices.keySet()) {
            list.add(neighbor.data);
        }
        return list;
    }
    public void add(Vertex<T> destin){
       adjacentVertices.put(destin, 0.0);

    }
    public int size(){
        return adjacentVertices.size();
    }
    public Double get(Vertex<T> v){
        return adjacentVertices.get(v);
    }
    public Double getWeight(Vertex<T> neighbor) {
        return adjacentVertices.get(neighbor);
    }
    public void addAdjacent(Vertex<T> neighbor, double weight) {
        adjacentVertices.put(neighbor, weight);
    }
    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
    public T getData() {
        return data;
    }
    public Map<Vertex<T>, Double> getDistance(Vertex<T> currentNode, Vertex<T> neighbour) {
        return getDistance(currentNode, neighbour);
    }


    // getters&setters constructors
    // equals
}






















