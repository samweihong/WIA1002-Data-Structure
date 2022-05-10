package tutorial7b;

import java.util.Comparator;
import java.util.PriorityQueue;

// Answers:
// a)
// To display the names in alphabetical order.
//
// b)
// Ali
// Jason
// Muhamad

public class Q4 {
    public static void main(String[] args) {
        PriorityQueue2.main(args);
    }
}

class PriorityQueue2 {
    public static void main(String... args ){
        PriorityQueueComparator pqc=new PriorityQueueComparator();
        PriorityQueue<String> pq=new PriorityQueue<String>(5,pqc);
        pq.add("Jason");
        pq.add("Ali");
        pq.add("Muhamad");
        for(String s:pq){
            System.out.println(s);
        }
    }
}
class PriorityQueueComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return -1;
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}
