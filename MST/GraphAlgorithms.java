import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.List;

/**
* Runs Prim's algorithm on the given graph and returns the Minimum
* Spanning Tree (MST) in the form of a set of Edges. If the graph is
* disconnected and therefore no valid MST exists, return null.
*
* assume that the passed in graph is undirected. In this framework,
* this means that if (u, v, 3) is in the graph, then the opposite edge
* (v, u, 3) will also be in the graph, though as a separate Edge object.
*
*
* assume that there will only be one valid MST that can be formed.
*
* assume that the passed in start vertex and graph will not be null.
* assume that the start vertex exists in the graph.   
*/
public class GraphAlgorithms {

    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        Set<Vertex<T>> vSet = new HashSet<>();
        Set<Edge<T>> mst = new HashSet<>();
        Queue<Edge<T>> q = new PriorityQueue<>();
        
        List<VertexDistance<T>> edges = graph.getAdjList().get(start);
        for (VertexDistance<T> edge : edges) {
            Edge<T> e = new Edge<>(start, edge.getVertex(), edge.getDistance());
            q.add(e);
        }
        vSet.add(start);
        while (!q.isEmpty() && vSet.size() < graph.getVertices().size()) {
            Edge<T> edge = q.remove();
            if (!vSet.contains(edge.getV())) {
                vSet.add(edge.getV());
                Edge<T> edge2 = new Edge(edge.getV(), edge.getU(), edge.getWeight());
                mst.add(edge);
                mst.add(edge2);
                List<VertexDistance<T>> moreEdges = graph.getAdjList().get(edge.getV());
                for (VertexDistance<T> moreEdge : moreEdges) {
                    Edge<T> e = new Edge<>(edge.getV(), moreEdge.getVertex(), moreEdge.getDistance());
                    if (!vSet.contains(e.getV())) {
                        q.add(e);
                    }
                }
            }
        }
        
        if (mst.size() == 2*(graph.getVertices().size() - 1)) {
            return mst;
        }
        return null;
    }

}