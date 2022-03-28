public final class VertexDistance<T> implements Comparable<VertexDistance<? super T>> {

    private final Vertex<T> vertex;
    private final int distance;

    /**
     * Creates a pairing of vertex and distance to that vertex.
     *
     * @param vertex the Vertex to be stored.
     * @param distance the integer representing the distance to this Vertex
     *                 from the previous Vertex.
     */
    public VertexDistance(Vertex<T> vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    /**
     * Gets the vertex.
     *
     * @return The vertex.
     */
    public Vertex<T> getVertex() {
        return vertex;
    }

    /**
     * Gets the distance
     *
     * @return The distance.
     */
    public int getDistance() {
        return distance;
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof VertexDistance<?>) {
            VertexDistance<?> e = (VertexDistance<?>) o;
            return distance == e.distance && vertex.equals(e.vertex);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return vertex.hashCode() ^ distance;
    }

    public int compareTo(VertexDistance<? super T> pair) {
        return this.getDistance() - pair.getDistance();
    }

    public String toString() {
        return "Pair with vertex " + vertex + " and distance " + distance;
    }
}