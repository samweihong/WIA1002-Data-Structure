package tutorial4;

public class Q3 {
    // a) removeLast
    // b)
    class LinkedList<E> {
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public E removeLast() {
            if (size == 0) return null;

            E item = tail.item;
            if (size == 1) {
                head = tail = null;
                size--;
                return item;
            }

            Node<E> pointer1 = head;
            for (int i = 1; i < size; i++)
                pointer1 = pointer1.next;
            pointer1.next = null;
            tail = pointer1;
            size--;
            return item;
        }

        private static class Node<E> {
            E item;
            Node<E> next;
        }
    }
}
