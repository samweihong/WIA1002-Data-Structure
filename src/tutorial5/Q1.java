package tutorial5;

public class Q1 {
    /*
     * a)
     * Line 10 - 13:
     * If index is 0, replace the head's element with e and return this new element.
     * However, it is expected that the head's initial element is returned.
     * Line 14 - 21:
     * Otherwise, replace the (index)th node's element with e and return this new element.
     * To do so, current is set to be the node before the (index)th node.
     * Then, the node after current is accessed to replace its element with e.
     * However, it is expected that the (index)th's initial element is returned.
     *
     * b)
     * Replace the (index)th node's element with e and return its initial element.
     * However, if the index is beyond the bounds, a node with element e will be added to the respective end and null will be returned.
     *
     * c)
     */
    class LinkedList<E> {
        private Node<E> head;
        private Node<E> tail;
        private int size = 0;

        private static class Node<E> {
            E element;
            Node<E> next;
        }

        public void addFirst(E e) {
            // lazy to implement
        }

        public void addLast(E e) {
            // lazy to implement
        }

        public E xyz(int index, E e) {
            if (index < 0) {
                addFirst(e);
                return null;
            }
            if (index >= size) {
                addLast(e);
                return null;
            }
            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
            E element = current.element;
            current.element = e;
            return element;
        }
    }
}
