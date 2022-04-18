package lab4;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node() {}

        public Node(E element) {
            this.element = element;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public void addFirst(E e) {
        Node<E> newHead = new Node<>(e);
        newHead.next = head;
        head = newHead;
        if (tail == null) tail = head;
    }

    public void addLast(E e) {
        Node<E> newTail = new Node<>(e);
        if (tail == null)
            head = newTail;
        else
            tail.next = newTail;
        tail = newTail;
    }

    public void add(int index, E e) {
        if (index <= 0) {
            addFirst(e);
            return;
        }
        try {
            Node<E> beforeToAdd = head;
            for (int i = 1; i < index; i++)
                beforeToAdd = beforeToAdd.next;

            Node<E> toAdd = new Node<>(e);
            toAdd.next = beforeToAdd.next;
            beforeToAdd.next = toAdd;
            if (toAdd.next == null) tail = toAdd;

        } catch (NullPointerException ex) {
            addLast(e);
        }
    }

    public E removeFirst() {
        if (head == null) return null;
        E item = head.element;
        head = head.next;
        if (head == null) tail = null;
        return item;
    }

    public E removeLast() {
        if (tail == null) return null;
        E item = tail.element;
        if (head == tail) {
            head = tail = null;
            return item;
        }

        Node<E> beforeLast = head;
        while (beforeLast.next.next != null)
            beforeLast = beforeLast.next;
        beforeLast.next = null;
        tail = beforeLast;

        return item;
    }

    public E remove(int index) {
        if (index < 0) return null;
        if (index == 0) return removeFirst();

        try {
            Node<E> beforeToRemove = head;
            for (int i = 1; i < index; i++)
                beforeToRemove = beforeToRemove.next;
            E item = beforeToRemove.next.element;
            beforeToRemove.next = beforeToRemove.next.next;
            if (beforeToRemove.next == null) tail = beforeToRemove;

            return item;

        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void add(E e) {
        addLast(e);
    }

    public boolean contains(E e) {
        for (Node<E> current = head; current != null; current = current.next)
            if (e.equals(current.element))
                return true;
        return false;
    }

    public E get(int index) {
        if (index < 0) return null;
        try {
            Node<E> current = head;
            while (index-- > 0)
                current = current.next;
            return current.element;
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public E getFirst() {
        if (head == null) return null;
        return head.element;
    }

    public E getLast() {
        if (tail == null) return null;
        return tail.element;
    }

    public int indexOf(E e) {
        int i = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            if (e.equals(current.element))
                return i;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(E e) {
        int index = -1;
        int i = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            if (e.equals(current.element))
                index = i;
            i++;
        }
        return index;
    }

    public E set(int index, E e) {
        if (index < 0) return null;
        try {
            Node<E> current = head;
            while (index-- > 0)
                current = current.next;

            E temp = current.element;
            current.element = e;
            return temp;

        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void clear() {
        head = tail = null;
    }

    public void print() {
        for (Node<E> current = head; current != null; current = current.next)
            System.out.print(current.element + " ");
        System.out.println();
    }

    public void reverse() {
        String s = "";
        for (Node<E> current = head; current != null; current = current.next)
            s = current.element + " " + s;
        System.out.println(s);
    }
}
