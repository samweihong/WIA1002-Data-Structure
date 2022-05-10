package tutorial7a;

import java.util.LinkedList;
import java.util.Queue;

public class Q4 {
    public static void main(String[] args) {
        Queue<Integer> X = new LinkedList<>();
        X.offer(new Integer(14));
        X.offer(new Integer(3));
        X.offer(new Integer(5));
        // X = [14,3,5]
        Object Y = X.poll();
        // X = [3,5]
        X.offer(new Integer(7));
        X.offer(new Integer(9));
        // X = [3,5,7,9]
        Y = X.poll();
        // X = [5,7,9], Y = 3
        X.offer(new Integer(2));
        X.offer(new Integer(4));
        // X = [5,7,9,2,4]
        X.peek();                       // a) 5

        Y = X.poll();
        // X = [7,9,2,4], Y = 5
        X.offer(new Integer(10));
        // X = [7,9,2,4,10]
        X.peek();                       // b) 7

        Y = X.poll();                   // c) 7
        // X = [9,2,4,10], Y = 7

        X.peek();                       // d) 9
    }
}
