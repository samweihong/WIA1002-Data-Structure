package tutorial7a;

import java.util.LinkedList;

public class Q5 {

}

class Queue<E> {
    LinkedList<E> list = new LinkedList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        return list.getFirst();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }
}
