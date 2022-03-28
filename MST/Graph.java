import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Graph<T> {

    private Set<Vertex<T>> vertices;
    private Set<Edge<T>> edges;
    private Map<Vertex<T>, List<VertexDistance<T>>> adjList;

    /**
     * Builds the graph from a set of vertices and an edge list.
     *
     * @param vertices The vertex set.
     * @param edges The edge set.
     * @throws IllegalArgumentException If any of the arguments are null or if
     * the vertex set doesn't contain all of the vertices.
     */
    public Graph(Set<Vertex<T>> vertices, Set<Edge<T>> edges) {
        if (vertices == null || edges == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }

        this.vertices = new HashSet<>(vertices);
        this.edges = new HashSet<>(edges);
        adjList = new HashMap<>();
        for (Vertex<T> v : vertices) {
            adjList.put(v, new ArrayList<>());
        }

        for (Edge<T> e : edges) {
            if (adjList.containsKey(e.getU())) {
                adjList.get(e.getU()).add(new VertexDistance<>(e.getV(), e.getWeight()));
            } else {
                throw new IllegalArgumentException("Vertex set must contain all vertices of the graph.");
            }
        }
    }

    /**
     * Gets the vertex set.
     *
     * @return The vertex set.
     */
    public Set<Vertex<T>> getVertices() {
        return vertices;
    }

    /**
     * Gets the edge set.
     *
     * @return The edge set.
     */
    public Set<Edge<T>> getEdges() {
        return edges;
    }

    /**
     * Gets the adjacency list.
     *
     * @return The adjacency list.
     */
    public Map<Vertex<T>, List<VertexDistance<T>>> getAdjList() {
        return adjList;
    }
}