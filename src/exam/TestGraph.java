package exam;

public class TestGraph {
    public static void main(String[] args) {
        RoutingGraph<Character, Double> graph = new RoutingGraph<>();
        graph.addVertex('A', "Housing Area");
        graph.addVertex('B', "Food Area");
        graph.addVertex('C', "Housing Area");
        graph.addVertex('D', "Food Area");
        graph.addVertex('E', "Food Area");
        graph.addVertex('F', "Industry Area");
        graph.addVertex('G', "Industry Area");

        graph.addUndirectedEdge('A', 'B', 7d);
        graph.addEdge('A', 'C', 10.1);
        graph.addUndirectedEdge('B', 'C', 5.5);
        graph.addEdge('B', 'E', 3.2);
        graph.addEdge('C', 'D', 8.3);
        graph.addEdge('D', 'G', 4.9);
        graph.addEdge('E', 'D', 2.9);
        graph.addUndirectedEdge('E', 'G', 6d);
        graph.addEdge('E', 'F', 4d);
        graph.addEdge('F', 'G', 2.3);

        System.out.println("The number of vertices in MyCityGraph: " + graph.getSize());

        System.out.println("List all vertices:");
        for (int i = 0; i < graph.getSize(); i++)
            System.out.print(i + ": " + graph.getVertex(i) + "\t");
        System.out.println();

        System.out.println("Has edge from B to A?\t" + graph.hasEdge('B', 'A'));
        System.out.println("Has edge from A to D?\t" + graph.hasEdge('A', 'D'));
        System.out.println();

        System.out.println("Find all neighbours of B : " + graph.getNeighbours('B'));
        System.out.println();

        System.out.println("Print all edges : ");
        graph.printEdges(2);
        System.out.println();

        char[][] paths = {
            {'A', 'B', 'C', 'D', 'G'}, // path 1
            {'A', 'B', 'E', 'G'},      // path 2
            {'A', 'B', 'E', 'D', 'G'}, // path 3
            {'A', 'B', 'E', 'F', 'G'}, // path 4
            {'A', 'C', 'D', 'G'},      // path 5
        };

        Path[] distances = new Path[5];
        Path[] durations = new Path[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Path " + (i+1) + ": ");
            System.out.print(paths[i][0]);
            for (int j = 1; j < paths[i].length; j++)
                System.out.print(" -> " + paths[i][j]);
            System.out.println();

            double distance = calculateDistance(graph, paths[i]);
            System.out.printf("Distance= %.2f km", distance);
            distances[i] = new Path(i+1, distance);

            double duration = calculateDuration(graph, paths[i]);
            System.out.printf(", Duration= %.2f min\n", duration);
            durations[i] = new Path(i+1, duration);
        }
        System.out.println();

        sortDistance(distances);
        System.out.println("After Bubble Sort:");
        for (int i = 0; i < 5; i++)
            System.out.printf("Path %d (%.2f km)\n", distances[i].index, distances[i].value);

        System.out.println();
        System.out.println();

        sortDuration(durations);
        System.out.println("After Insertion Sort:");
        for (int i = 0; i < 5; i++)
            System.out.printf("Path %d (%.2f min)\n", durations[i].index, durations[i].value);
    }


    public static double calculateDistance(RoutingGraph<Character, Double> graph, char[] path) {
        double distance = 0;
        for (int i = 0; i < path.length - 1; i++)
            distance += graph.getEdgeWeight(path[i], path[i+1]);
        return distance;
    }

    public static double calculateDuration(RoutingGraph<Character, Double> graph, char[] path) {
        double duration = 0;
        for (int i = 0; i < path.length - 1; i++) {
            double distance = graph.getEdgeWeight(path[i], path[i+1]);
            double speed = graph.getEdgeSpeed(path[i], path[i+1], 2);
            duration += distance * speed;
        }
        return duration;
    }

    public static void sortDistance(Path[] distances) {
        boolean needNextPass = true;
        for (int k = 1; k < distances.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < distances.length - k; i++)
                if (distances[i].value > distances[i + 1].value) {
                    Path temp = distances[i];
                    distances[i] = distances[i + 1];
                    distances[i + 1] = temp;
                    needNextPass = true;
                }
        }
    }

    public static void sortDuration(Path[] durations) {
        for (int i = 1; i < durations.length; i++) {
            Path current = durations[i];
            int j;
            for (j = i-1; j >= 0 && current.value > durations[j].value; j--)
                durations[j+1] = durations[j];
            durations[j+1] = current;
        }
    }

    private static class Path {
        int index;
        double value;

        public Path(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
