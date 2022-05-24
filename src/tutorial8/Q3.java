package tutorial8;

public class Q3 {
    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>();
        for (char c = 'A'; c <= 'I'; c++)
            graph.addVertex(c);
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'G');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        // Adjacency list is used.
    }
}

class Graph<T extends Comparable<T>> {
    private Vertex<T> head;
    private int size;

    private static class Vertex<T extends Comparable<T>> {
        T vertexInfo;
        Vertex<T> nextVertex;
        Edge<T> firstEdge;

        public Vertex() {
            this(null, null);
        }

        public Vertex(T vInfo, Vertex<T> next) {
            vertexInfo = vInfo;
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

    public boolean addVertex(T v) {
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

    public boolean addEdge(T source, T destination) {
        for (Vertex<T> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex)
            if (sourceVertex.vertexInfo.compareTo(source) == 0)
                for (Vertex<T> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex)
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, sourceVertex.firstEdge);
                        return true;
                    }
        return false;
    }
}
