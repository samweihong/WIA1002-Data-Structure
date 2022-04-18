package tutorial4;

public class Q1 {
    public static void main(String[] args) {
        LinkedList.main(args);
    }
}

class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        // a)
        LinkedList<Character> list = new LinkedList<>();
        Node<Character> node1 = new Node<>('a');
        Node<Character> node2 = new Node<>('z');
        list.head = node1;
        list.tail = node2;

        // c)
        node1.next = node2;

        // h)
        list.addLast('c');
        list.add(2, 'd');
        list.remove(1);
    }

    public void addFirst(E e) {
//        e)
//        Condition to consider:
//        Whether the list contains any node.
//        If it doesn't, the tail should be set to this new node.
//
//        f)
//        Set the next of this firstNode to the current head.
//        Set the head to this firstNode.
//
//        g)
        Node<E> firstNode = new Node<>(e);
        firstNode.next = head;
        head = firstNode;
        if (tail == null) tail = head;
    }

    public void addLast(E e) {
//        e)
//        Condition to consider:
//        Whether the list contains any node.
//        If it doesn't, both the head and tail should be set to this new node.
//
//        f)
//        Set the next of the current node to this new node.
//        Set the tail to this new node.
//
//        g)
        Node<E> newTail = new Node<>(e);
        if (tail == null) {
            head = tail = newTail;
            return;
        }
        tail.next = newTail;
        tail = newTail;
    }

    public void add(int index, E e) {
//        e)
//        Condition to consider:
//        Whether the index is less than 0 or greater than the size of the list.
//        If so, we can either throw an exception or append the node to the respective end of the list.
//
//        f)
//        If the index is 0, invoke the addFirst method.
//        If the index is equal to the size of the list, invoke the addLast method.
//        Otherwise, search for (index-1)th node and assign it to current.
//        Set the next of this new node to the node after the current.
//        Set the next of the current to this new node.
//
//        g)
        if (index <= 0) {
            addFirst(e);
            return;
        }

        try {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;

            Node<E> newNode = new Node<>(e);
            newNode.next = current.next;
            current.next = newNode;
            if (newNode.next == null) tail = newNode;

        } catch (NullPointerException ex) {
            addLast(e);
        }
    }

    public E removeFirst() {
//        e)
//        Condition to consider:
//        Whether the list contains any node.
//        If it doesn't, null is returned.
//        Whether the list contains only one node.
//        If so, set both the head and tail to null and return the item of that node.
//
//        f)
//        Set the head to the node after the current head.
//        Return the item of the initial head.
//
//        g)
        if (head == null) return null;
        E item = head.item;
        head = head.next;
        if (head == null) tail = null;
        return item;
    }

    public E removeLast() {
//        e)
//        Condition to consider:
//        Whether the list contains any node.
//        If it doesn't, null is returned.
//        Whether the list contains only one node.
//        If so, set both the head and tail to null and return the item of that node.
//
//        f)
//        Assign the node before the tail to current.
//        Set the next of the current to null.
//        Return the item of the initial tail.
//
//        g)
        if (tail == null) return null;

        E item = tail.item;
        if (head.next == null) {
            head = tail = null;
            return item;
        }
        Node<E> current = head;
        while (current.next.next != null)
            current = current.next;
        current.next = null;
        tail = current;
        return item;
    }

    public E remove(int index) {
//        e)
//        Condition to consider:
//        Whether the index is less than 0 or greater than or equal to the size of the list.
//        If so, we can either throw an exception or return null.
//
//        f)
//        If the index is 0, invoke the removeFirst method.
//        Otherwise, search for (index-1)th node and assign it to current.
//        Set the next of the current to the node after the next of the current.
//        Return the item of the node after the initial current.
//
//        g)
        if (index < 0) return null;
        if (index == 0) return removeFirst();

        try {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            E item = current.next.item;
            current.next = current.next.next;
            if (current.next == null) tail = current;

            return item;

        } catch (NullPointerException ex) {
            return null;
        }
    }
}
