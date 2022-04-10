package lab4;

public class Q2 {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        System.out.println(list1.getMiddleValue());

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(8);
        System.out.println(list2.getMiddleValue());
    }
}

class LinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;

    private static class Node<E> {
        E item;
        Node<E> next;
    }

    public void addLast(E e) {
        Node<E> newTail = new Node<>();
        newTail.item = e;
        if (tail == null)
            head = newTail;
        else
            tail.next = newTail;
        tail = newTail;
    }

//    public E getMiddleValue() {
//        int n = 0;
//        for (Node<E> current = head; current != null; current = current.next)
//            n++;
//
//        Node<E> current = head;
//        for (int i = 0; i < n/2; i++)
//            current = current.next;
//        return (current == null ? null : current.item);
//    }

    public E getMiddleValue() {
        Node<E> slow = head;
        Node<E> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return (slow == null ? null : slow.item);
    }
}
