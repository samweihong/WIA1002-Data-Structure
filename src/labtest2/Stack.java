package labtest2;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        return list.remove(list.size()-1);
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
