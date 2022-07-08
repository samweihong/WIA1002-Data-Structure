package exam;

import java.util.ArrayList;
import java.util.Stack;

public class RoutingGraph<T extends Comparable<T>, N extends Comparable<N>> {
    private Vertex<T, N> head;
    private int size;

    private static class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
        T name;
        String type;
        Vertex<T, N> nextVertex;
        Edge<T, N> firstEdge;

        public Vertex(T name, String type, Vertex<T, N> next) {
            this.name = name;
            this.type = type;
            nextVertex = next;
            firstEdge = null;
        }
    }

    private static class Edge<T extends Comparable<T>, N extends Comparable<N>> {
        Vertex<T, N> toVertex;
        N weight;
        Edge<T, N> nextEdge;

        public Edge(Vertex<T, N> destination, N w, Edge<T, N> a) {
            toVertex = destination;
            weight = w;
            nextEdge = a;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean hasVertex(T v)	{
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex)
            if (current.name.compareTo(v) == 0)
                return true;
        return false;
    }

    public boolean addVertex(T v, String type) {
        if (hasVertex(v)) return false;

        Vertex<T, N> newVertex = new Vertex<>(v, type, null);
        if (head == null)
            head = newVertex;
        else {
            Vertex<T, N> current = head;
            while (current.nextVertex != null)
                current = current.nextVertex;
            current.nextVertex = newVertex;
        }
        size++;
        return true;
    }

    public T getVertex(int pos) {
        if (pos < 0 || pos >= size) return null;

        Vertex<T, N> current = head;
        for (int i = 0; i < pos; i++)
            current = current.nextVertex;
        return current.name;
    }

    public boolean addEdge(T source, T destination, N w) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.name.compareTo(source) == 0)
                for (Vertex<T, N> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex)
                    if (destinationVertex.name.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, w, sourceVertex.firstEdge);
                        return true;
                    }
        return false;
    }

    public boolean addUndirectedEdge(T source, T destination, N w) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.name.compareTo(source) == 0)
                for (Vertex<T, N> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex)
                    if (destinationVertex.name.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, w, sourceVertex.firstEdge);
                        destinationVertex.firstEdge = new Edge<>(sourceVertex, w, destinationVertex.firstEdge);
                        return true;
                    }
        return false;
    }

    public boolean hasEdge(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.name.compareTo(source) == 0)
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                    if (currentEdge.toVertex.name.compareTo(destination) == 0)
                        return true;
        return false;
    }

    public N getEdgeWeight(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) return null;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.name.compareTo(source) == 0)
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge=currentEdge.nextEdge)
                    if (currentEdge.toVertex.name.compareTo(destination) == 0)
                        return currentEdge.weight;
        return null;
    }

    public double getEdgeSpeed(T source, T destination, int y) {
        if (!hasVertex(source) || !hasVertex(destination)) return -1;

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.name.compareTo(source) == 0)
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge=currentEdge.nextEdge)
                    if (currentEdge.toVertex.name.compareTo(destination) == 0) {
                        String currentVertexType = sourceVertex.type;
                        String nextVertexType = currentEdge.toVertex.type;
                        if (currentVertexType.equals("Housing Area") && nextVertexType.equals("Housing Area"))
                            return y;
                        else if (currentVertexType.equals("Housing Area") && nextVertexType.equals("Food Area")
                                || currentVertexType.equals("Food Area") && nextVertexType.equals("Housing Area"))
                            return y;
                        else if (currentVertexType.equals("Food Area") && nextVertexType.equals("Food Area"))
                            return 1.25 * y;
                        else if (currentVertexType.equals("Food Area") && nextVertexType.equals("Industry Area")
                                || currentVertexType.equals("Industry Area") && nextVertexType.equals("Food Area"))
                            return 1.5 * y;
                        else if (currentVertexType.equals("Industry Area") && nextVertexType.equals("Industry Area"))
                            return 3 * y;
                    }
        return -1;
    }

    public ArrayList<T> getNeighbours(T v) {
        if (!hasVertex(v)) return null;

        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex)
            if (current.name.compareTo(v) == 0)
                for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                    list.add(currentEdge.toVertex.name);
        return list;
    }

    public void printEdges(int y) {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            System.out.printf("# %s : ", current.name);
            for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                String currentVertexType = current.type;
                String nextVertexType = currentEdge.toVertex.type;
                double speed = -1;
                if (currentVertexType.equals("Housing Area") && nextVertexType.equals("Housing Area"))
                    speed = y;
                else if (currentVertexType.equals("Housing Area") && nextVertexType.equals("Food Area")
                         || currentVertexType.equals("Food Area") && nextVertexType.equals("Housing Area"))
                    speed = y;
                else if (currentVertexType.equals("Food Area") && nextVertexType.equals("Food Area"))
                    speed = 1.25 * y;
                else if (currentVertexType.equals("Food Area") && nextVertexType.equals("Industry Area")
                         || currentVertexType.equals("Industry Area") && nextVertexType.equals("Food Area"))
                    speed = 1.5 * y;
                else if (currentVertexType.equals("Industry Area") && nextVertexType.equals("Industry Area"))
                    speed = 3 * y;

                System.out.print("[" + current.name + "," + currentEdge.toVertex.name +
                                 "(speed=" + speed + " , distance=" + currentEdge.weight + ")] ");
            }
            System.out.println();
        }
    }
}
