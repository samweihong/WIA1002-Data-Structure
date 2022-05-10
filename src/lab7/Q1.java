package lab7;

import java.util.Collections;
import java.util.LinkedList;

public class Q1 {
    public static void main(String[] args) {
        String[] fruitQ = {"Durian", "Blueberry"};
        MyQueue<String> q = new MyQueue<>(fruitQ);
        q.enqueue("Apple");
        q.enqueue("Orange");
        q.enqueue("Grapes");
        q.enqueue("Cherry");
        System.out.println(q);
        System.out.println("Top item: " + q.peek());
        System.out.println("Queue size: " + q.getSize());
        System.out.println(q.dequeue() + " is deleted");
        System.out.println(q.getElement(2) + " is in index position of 2");
        System.out.println("Queue consists of Cherry: " + q.contains("Cherry"));
        System.out.println("Queue consists of Durian: " + q.contains("Durian"));
        while (!q.isEmpty())
            System.out.print(q.dequeue() + " ");
        System.out.println();
    }
}

class MyQueue<E> {
    private LinkedList<E> list;

    public MyQueue(E[] e) {
        this();
        Collections.addAll(list, e);
    }

    public MyQueue() {
        list = new LinkedList<>();
    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.getFirst();
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}