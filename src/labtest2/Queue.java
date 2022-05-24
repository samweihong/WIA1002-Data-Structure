package labtest2;

import java.util.LinkedList;

public class Queue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E peek() {
        return list.peek();
    }

    public int getSize() {
        return list.size();
    }
    public E get(int i) {
        return list.get(i);
    }

    public boolean contains(E e) {
        return list.contains(e);
    }
    public int indexOf(E e) {
        return list.indexOf(e);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < getSize(); i++)
            res += get(i) + " --> ";
        return res;
    }
}
