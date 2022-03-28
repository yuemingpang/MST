public class Vertex<T> {

    private T data;

    /**
     * Creates a Vertex object holding the given data.
     *
     * @param data The object that is stored in this Vertex.
     * @throws IllegalArgumentException If data is null.
     */
    public Vertex(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        this.data = data;
    }

    /**
     * Gets the data.
     *
     * @return The data of this vertex.
     */
    public T getData() {
        return data;
    }

    public boolean equals(Object o) {
        if (o != null && o instanceof Vertex) {
            return data.equals(((Vertex<?>) o).data);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return data.hashCode();
    }

    public String toString() {
        return data.toString();
    }
}