package labtest3;

import java.util.ArrayList;
import java.util.Arrays;

public class UnweightedGraph<T extends Comparable<T>> {
    private Vertex<T> head;
    private int size;

    private static class Vertex<T extends Comparable<T>> {
        T vertexInfo;
        int indeg;
        int outdeg;
        Vertex<T> nextVertex;
        Edge<T> firstEdge;

        public Vertex() {
            this(null, null);
        }

        public Vertex(T vInfo, Vertex<T> next) {
            vertexInfo = vInfo;
            indeg = 0;
            outdeg = 0;
            nextVertex = next;
            firstEdge = null;
        }

        @Override
        public String toString() {
            return vertexInfo.toString();
        }
    }

    private static class Edge<T extends Comparable<T>> {
        Vertex<T> toVertex;
        Edge<T> nextEdge;

        public Edge() {
            this(null, null);
        }

        public Edge(Vertex<T> destination, Edge<T> a) {
            toVertex = destination;
            nextEdge = a;
        }
    }

    public UnweightedGraph() {
        head = null;
        size = 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getIndeg(T v)  {
        for (Vertex<T> current = head; current != null; current = current.nextVertex)
            if (current.vertexInfo.compareTo(v) == 0)
                return current.indeg;
        return -1;
    }

    public int getOutdeg(T v)  {
        for (Vertex<T> current = head; current != null; current = current.nextVertex)
            if (current.vertexInfo.compareTo(v) == 0)
                return current.outdeg;
        return -1;
    }

    public boolean hasVertex(T v)	{
        for (Vertex<T> current = head; current != null; current = current.nextVertex)
            if (current.vertexInfo.compareTo(v) == 0)
                return true;
        return false;
    }

    public boolean addVertex(T v) {
        if (hasVertex(v)) return false;

        Vertex<T> newVertex = new Vertex<>(v, null);
        if (head == null)
            head = newVertex;
        else {
            Vertex<T> current = head;
            while (current.nextVertex != null)
                current = current.nextVertex;
            current.nextVertex = newVertex;
        }
        size++;
        return true;
    }

    public int getIndex(T v) {
        int pos = 0;
        for (Vertex<T> current = head; current != null; current = current.nextVertex, pos++)
            if (current.vertexInfo.compareTo(v) == 0)
                return pos;
        return -1;
    }

    public int getIndex(Vertex<T> v) {
        int pos = 0;
        for (Vertex<T> current = head; current != null; current = current.nextVertex, pos++)
            if (current.equals(v))
                return pos;
        return -1;
    }

    public Vertex<T> getVertex(int pos) {
        if (pos < 0 || pos >= size) return null;

        Vertex<T> current = head;
        for (int i = 0; i < pos; i++)
            current = current.nextVertex;
        return current;
    }

    public Vertex<T> getVertex(T v) {
        for (Vertex<T> currentVertex = head; currentVertex != null; currentVertex = currentVertex.nextVertex)
            if (currentVertex.vertexInfo.equals(v))
                return currentVertex;
        return null;
    }

    public boolean addEdge(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0)
                for (Vertex<T> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex)
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, sourceVertex.firstEdge);
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
        return false;
    }

    public boolean addUndirectedEdge(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0)
                for (Vertex<T> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex)
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        destinationVertex.firstEdge = new Edge<>(sourceVertex, destinationVertex.firstEdge);
                        destinationVertex.outdeg++;
                        sourceVertex.indeg++;
                        if (sourceVertex != destinationVertex) {
                            sourceVertex.firstEdge = new Edge<>(destinationVertex, sourceVertex.firstEdge);
                            sourceVertex.outdeg++;
                            destinationVertex.indeg++;
                        }
                        return true;
                    }
        return false;
    }

    public boolean hasEdge(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) return false;

        for (Vertex<T> sourceVertex = head; sourceVertex != null; sourceVertex=sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0)
                for (Edge<T> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0)
                        return true;
        return false;
    }

    public void printEdges() {
        for (Vertex<T> current = head; current != null; current = current.nextVertex) {
            System.out.printf("%s : ", current.vertexInfo);
            for (Edge<T> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                System.out.printf("(%s, %s) ", current.vertexInfo, currentEdge.toVertex.vertexInfo);
            System.out.println();
        }
    }

    public int[][] getAdjacencyMatrix() {
        int[][] adjacencyMatrix = new int[size][size];
        int i = 0;
        for (Vertex<T> currentVertex = head; currentVertex != null; currentVertex = currentVertex.nextVertex) {
            for (Edge<T> currentEdge = currentVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                adjacencyMatrix[i][getIndex(currentEdge.toVertex.vertexInfo)] = 1;
            i++;
        }
        return adjacencyMatrix;
    }

    public void printAdjacencyMatrix() {
        int[][] adjacencyMatrix = getAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++)
            System.out.println(Arrays.toString(adjacencyMatrix[i]) + " " + getVertex(i));
    }

    public boolean DFS(Vertex<T> root) {
        Stack<Vertex<T>> stack = new Stack<>();
        boolean[] seen = new boolean[size];
        stack.push(root);
        seen[getIndex(root.vertexInfo)] = true;

        while (!stack.isEmpty()) {
            Vertex<T> vertex = stack.pop();
            System.out.println("At node " + vertex.vertexInfo + ":");
            ArrayList<T> list = new ArrayList<>();
            for (Edge<T> currentEdge = vertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                Vertex<T> toVertex = currentEdge.toVertex;
                if (!seen[getIndex(toVertex)])
                    stack.push(toVertex);
                seen[getIndex(toVertex)] = true;
                list.add(toVertex.vertexInfo);
            }
            System.out.println("\tsee : " + list);
            System.out.println("\tstack : " + stack);
        }

        for (boolean node : seen)
            if (!node) return false;
        return true;
    }
}
