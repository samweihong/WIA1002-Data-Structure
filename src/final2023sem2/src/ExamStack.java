import java.util.LinkedList;

public class ExamStack<E> {
    private LinkedList<E> list;

    public ExamStack() {
        list = new LinkedList<>();
    }

    public E peep() {
        return list.getLast();
    }

    public E pop() {
        return list.removeLast();
    }

    public void push(E el) {
        list.addLast(el);
    }

    public int getSize() {
        return list.size();
    }
}
