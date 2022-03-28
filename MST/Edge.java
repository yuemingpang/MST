public class Edge<T> implements Comparable<Edge<? super T>> {

    private Vertex<T> u;
    private Vertex<T> v;
    private int weight;

    /**
     * Creates a directed edge from vertex u to vertex v. Any single edge is
     * always directed, so if you're trying to create an undirected edge.
     *
     * @param u The start vertex of the edge.
     * @param v The end vertex of the edge.
     * @param weight The weight value of the edge.
     * @throws IllegalArgumentException if any of the arguments are null.
     */
    public Edge(Vertex<T> u, Vertex<T> v, int weight) {
        if (u == null || v == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    /**
     * Gets the weight.
     *
     * @return The weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the starting vertex (u).
     *
     * @return The starting vertex (u).
     */
    public Vertex<T> getU() {
        return u;
    }

    /**
     * Gets the ending vertex(v).
     *
     * @return The ending vertex (v).
     */
    public Vertex<T> getV() {
        return v;
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof Edge<?>) {
            Edge<?> e = (Edge<?>) o;
            return weight == e.weight && u.equals(e.u) && v.equals(e.v);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return u.hashCode() ^ v.hashCode() ^ weight;
    }

    public int compareTo(Edge<? super T> e) {
        return weight - e.getWeight();
    }

    public String toString() {
        return "Edge from " + u + " to " + v + " with weight " + weight;
    }
}