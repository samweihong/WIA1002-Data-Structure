package tutorial4;

public class Q2 {
    // a) contains
    // b)
    class LinkedList<E> {
        private Node<E> head = null;
        private Node<E> tail = null;
        private int size = 0;

        public boolean contains(E e) {
            Node<E> pointerB = head;
            for (int i = 0; i < size; i++) {
                if (e.equals(pointerB.element))
                    return true;
                pointerB.next = pointerB;
            }
            return false;
        }

        private static class Node<E> {
            E element;
            Node<E> next;
        }
    }
}
