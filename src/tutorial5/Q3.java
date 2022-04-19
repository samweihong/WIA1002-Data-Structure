package tutorial5;

public class Q3 {
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node<Character> head = new Node<>('a');
        Node<Character> middle = new Node<>('b', head, null);
        Node<Character> tail = new Node<>('c', middle, null);
        head.next = middle;
        middle.next = tail;

        Node<Character> newNode = new Node<>('z');
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
}
