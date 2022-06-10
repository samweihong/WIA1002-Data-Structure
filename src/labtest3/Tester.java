package labtest3;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        UnweightedGraph<String> graph = new UnweightedGraph<>();
        String[] actors = {"Ben Whishaw", "Jeffrey Wright", "Joseph Mazzello", "Nick Frost", "Rami Malek", "Robert Popper", "Simon Pegg", "Ving Rhames"};
        for (String actor : actors)
            graph.addVertex(actor);
        graph.addUndirectedEdge("Ben Whishaw", "Ben Whishaw");
        graph.addUndirectedEdge("Jeffrey Wright", "Jeffrey Wright");
        graph.addUndirectedEdge("Joseph Mazzello", "Joseph Mazzello");
        graph.addUndirectedEdge("Nick Frost", "Nick Frost");
        graph.addUndirectedEdge("Rami Malek", "Rami Malek");
        graph.addUndirectedEdge("Robert Popper", "Robert Popper");
        graph.addUndirectedEdge("Simon Pegg", "Simon Pegg");
        graph.addUndirectedEdge("Ving Rhames", "Ving Rhames");

        graph.addUndirectedEdge("Ben Whishaw", "Jeffrey Wright");
        graph.addUndirectedEdge("Ben Whishaw", "Rami Malek");
        graph.addUndirectedEdge("Jeffrey Wright", "Rami Malek");
        graph.addUndirectedEdge("Joseph Mazzello", "Rami Malek");
        graph.addUndirectedEdge("Nick Frost", "Robert Popper");
        graph.addUndirectedEdge("Nick Frost", "Simon Pegg");
        graph.addUndirectedEdge("Robert Popper", "Simon Pegg");
        graph.addUndirectedEdge("Simon Pegg", "Ving Rhames");

        System.out.println("Print edges:");
        graph.printEdges();
        System.out.println();

        System.out.println("Print adjacency matrix:");
        // Using hard-coding
        int[][] adjacencyMatrix = {
            {1, 1, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 1, 0},
            {1, 1, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1},
        };
        for (int i = 0; i < adjacencyMatrix.length; i++)
            System.out.println(Arrays.toString(adjacencyMatrix[i]) + " " + graph.getVertex(i));

        // Using algorithm
//        graph.printAdjacencyMatrix();
        System.out.println();

        System.out.println("Depth first search:");
        boolean isConnected = graph.DFS(graph.getVertex("Ben Whishaw"));
        System.out.println();
        if (isConnected)
            System.out.println("All the actors are connected.");
        else
            System.out.println("Not all the actors are connected.");
    }
}
