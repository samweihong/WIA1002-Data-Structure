public class CircularDoublyLinkedList<E> {
    private class Node {
        E el;
        Node prev;
        Node next;

        Node(E el) {
            this.el = el;
        }
    }

    private Node head;
    private Node tail;

    public void addLast(E el) {
        if (head == null) {
            Node newNode = new Node(el);
            head = tail = newNode;
            newNode.prev = newNode.next = newNode;
            return;
        }

        Node newNode = new Node(el);
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        tail.next = newNode;
        tail = newNode;
    }

    // non-destructive
    public void append(CircularDoublyLinkedList<E> list) {
        if (list == null || list.head == null) return;

        Node cur = list.head;
        do {
            addLast(cur.el);
            cur = cur.next;
        } while (cur != list.head);
    }

    @Override
    public String toString() {
        if (head == null) return "";

        String res = "";
        Node cur = head;
        do {
            res += cur.el + " ";
            cur = cur.next;
        } while (cur != head);
        return res;
    }
}
