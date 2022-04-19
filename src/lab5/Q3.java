package lab5;

import java.util.NoSuchElementException;

public class Q3 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(10);
        list.addLast(100);

        list.add(2, 2);
        list.remove(3);
        System.out.println();

        list.iterateForward();
        list.iterateBackward();

        System.out.println("size of current Doubly Linked List: " + list.getSize());
        list.clear();
        System.out.println();

        System.out.println("size of current Doubly Linked List: " + list.getSize());
    }
}

class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = head;
        size++;
        System.out.println("adding: " + e);
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        if (tail != null) tail.next = node;
        node.prev = tail;
        tail = node;
        if (head == null) head = tail;
        size++;
        System.out.println("adding: " + e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            addFirst(e);
        else if (index == size)
            addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;

            Node<E> node = new Node<>(e);
            node.prev = current;
            node.next = current.next;
            current.next = node;
            node.next.prev = node;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null)
            throw new NoSuchElementException();
        E item = head.item;
        head = head.next;
        if (head != null)
            head.prev = null;
        else
            tail = null;
        size--;
        System.out.println("deleted: " + item);
        return item;
    }

    public E removeLast() {
        if (tail == null)
            throw new NoSuchElementException();
        E item = tail.item;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        size--;
        System.out.println("deleted: " + item);
        return item;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return removeFirst();
        if (index == size-1)
            return removeLast();

        Node<E> node = head;
        for (int i = 0; i < index; i++)
            node = node.next;
        E item = node.item;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        System.out.println("deleted: " + item);
        return item;
    }

    public void iterateForward() {
        System.out.println("iterating forward..");
        for (Node<E> current = head; current != null; current = current.next)
            System.out.print(current.item + " ");
        System.out.println();
    }

    public void iterateBackward() {
        System.out.println("iterating backward..");
        for (Node<E> current = tail; current != null; current = current.prev)
            System.out.print(current.item + " ");
        System.out.println();
    }

    public void clear() {
        head = tail = null;
        System.out.printf("successfully clear %d node(s)\n", size);
        size = 0;
    }
}
