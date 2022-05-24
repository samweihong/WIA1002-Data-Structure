package tutorial8;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0,0,1,1,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0}
        };
        System.out.println(Arrays.deepToString(adjacencyMatrix));
        // Adjacency matrix is used.
    }
}
