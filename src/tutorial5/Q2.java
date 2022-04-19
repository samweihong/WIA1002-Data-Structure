package tutorial5;

public class Q2 {
    /*
     * a)
     * Summary: Remove the (index)th node from a doubly linked list.
     * Line 2 - 5:
     * Set temp to point to the (index)th node to be removed.
     * Line 6:
     * Assign the element of temp to element, to be returned later.
     * Line 7:
     * Set prev of the node after temp to the node before temp (skipping the node to be removed).
     * Line 8:
     * Set next of the node before temp to the node after temp (skipping the node to be removed).
     * Line 9 - 10:
     * (Unnecessarily) Set the next and prev of temp to null.
     * Line 11:
     * Decrement size by 1 as one node is removed.
     */
    class DoublyLinkedList<E> {
        private Node<E> head;
        private Node<E> tail;
        private int size;

        private static class Node<E> {
            E element;
            Node<E> prev;
            Node<E> next;
        }

        public E remove(int index) {
            E element = null;
            if (index <= 0 || index >= size-1) {}
            else {
                Node<E> temp = head;
                for (int i = 0; i < index; i++)
                    temp = temp.next;
                element = temp.element;
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
                temp.next = null;
                temp.prev = null;
                size--;
            }
            return element;
        }
    }
}
