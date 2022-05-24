package lab8;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>> {
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

    public Graph() {
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

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T> current = head; current != null; current = current.nextVertex)
            list.add(current.vertexInfo);
        return list;
    }

    public ArrayList<Vertex<T>> getAllVertices() {
        ArrayList<Vertex<T>> list = new ArrayList<>();
        for (Vertex<T> current = head; current != null; current = current.nextVertex)
            list.add(current);
        return list;
    }

    public T getVertex(int pos) {
        if (pos < 0 || pos >= size) return null;

        Vertex<T> current = head;
        for (int i = 0; i < pos; i++)
            current = current.nextVertex;
        return current.vertexInfo;
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
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, sourceVertex.firstEdge);
                        destinationVertex.firstEdge = new Edge<>(sourceVertex, destinationVertex.firstEdge);
                        sourceVertex.indeg++;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        destinationVertex.outdeg++;
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

    public ArrayList<T> getNeighbours(T v) {
        if (!hasVertex(v)) return null;

        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T> current = head; current != null; current = current.nextVertex)
            if (current.vertexInfo.compareTo(v) == 0)
                for (Edge<T> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                    list.add(currentEdge.toVertex.vertexInfo);
        return list;
    }

    public void printEdges() {
        for (Vertex<T> current = head; current != null; current = current.nextVertex) {
            System.out.printf("# %s : ", current.vertexInfo);
            for (Edge<T> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
                System.out.printf("[%s,%s] ", current.vertexInfo, currentEdge.toVertex.vertexInfo);
            System.out.println();
        }
    }
}

class TestGraph {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String i : cities)
            graph.addVertex(i);

        System.out.println("The number of vertices in graph: " + graph.getSize());

        System.out.println("Cities and their vertices ");
        for (int i = 0; i < graph.getSize(); i++)
            System.out.print(i + ": " + graph.getVertex(i) + "\t");
        System.out.println();

        System.out.println("Is Melaka in the Graph? " + graph.hasVertex("Melaka"));
        System.out.println("Is Ipoh in the Graph? " + graph.hasVertex("Ipoh"));
        System.out.println();

        System.out.println("Kuching at index:  " + graph.getIndex("Kuching"));
        System.out.println("Ipoh at index:  " + graph.getIndex("Ipoh"));
        System.out.println();

        System.out.println("add edge Kuching - Melaka: " + graph.addEdge("Kuching", "Melaka"));
        System.out.println("add edge Langkawi - Penang : " + graph.addEdge("Langkawi", "Penang"));
        System.out.println("add edge Melaka - Penang : " + graph.addEdge("Melaka", "Penang"));
        System.out.println("add edge Alor Setar - Kuching : " + graph.addEdge("Alor Setar", "Kuching"));
        System.out.println("add edge Tawau - Alor Setar : " + graph.addEdge("Tawau", "Alor Setar"));
        System.out.println("add edge Kuching - Tawau : " + graph.addEdge("Kuching", "Tawau"));
        System.out.println("add edge Langkawi - Ipoh : " + graph.addEdge("Langkawi", "Ipoh"));
        System.out.println();

        System.out.println("has edge from Kuching to Melaka?  " + graph.hasEdge("Kuching", "Melaka") );
        System.out.println("has edge from Melaka to Langkawi?  " + graph.hasEdge("Melaka", "Kuching") );
        System.out.println("has edge from Ipoh to Langkawi?  " + graph.hasEdge("Ipoh", "Langkawi") );
        System.out.println();

        System.out.println("In and out degree for Kuching is " + graph.getIndeg("Kuching") + " and " + graph.getOutdeg("Kuching") );
        System.out.println("In and out degree for Penang is " + graph.getIndeg("Penang") + " and " + graph.getOutdeg("Penang") );
        System.out.println("In and out degree for Ipoh is " + graph.getIndeg("Ipoh") + " and " + graph.getOutdeg("Ipoh") );
        System.out.println();

        System.out.println("Neighbours of Kuching : " + graph.getNeighbours("Kuching"));
        System.out.println("\nPrint Edges : " );
        graph.printEdges();
    }
}
