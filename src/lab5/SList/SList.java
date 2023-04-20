package lab5.SList;

public class SList<E> {
    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    public void appendEnd(E e) {
        SNode<E> node = new SNode<>(e);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
    }

    public E removeInitial() {
        if (head == null) return null;
        E item = head.item;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return item;
    }

    public boolean contains(E e) {
        for (SNode<E> node = head; node != null; node = node.next)
            if (e.equals(node.item))
                return true;
        return false;
    }

    public void clear() {
        head = tail = null;
        size = 0;
        System.out.println("The list is empty.");
    }

    public void display() {
        for (SNode<E> node = head; node != null; node = node.next)
            System.out.print(node.item + " ");
        System.out.println();
    }
}
