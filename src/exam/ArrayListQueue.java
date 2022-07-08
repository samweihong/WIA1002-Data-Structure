package exam;

import java.util.ArrayList;

public class ArrayListQueue<E> {
    private int size = 10;
    private int front = 0;
    private int end = 0;
    private ArrayList<E> list = new ArrayList<>(size);

    public boolean enqueue(E o) {
        boolean success = false;
        if (end < size) {
            success = list.add(o);
            end++;
        }
        return success;
    }

    public E dequeue() {
        if (front == end) return null;
        size--;
        return list.get(front++);
    }

    public String queueToString() {
        if (front == end) return "";

        String s = "";
        for (int i = front; i < end; i++)
            s += list.get(i) + ", ";
        return s.substring(0, s.length()-2); // Remove the last comma
    }

    public String allToString() {
        return "ALL : " + list.toString();
    }
}
