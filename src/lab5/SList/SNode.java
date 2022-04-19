package lab5.SList;

public class SNode<E> {
    E item;
    SNode<E> next;

    public SNode() {
        item = null;
        next = null;
    }

    public SNode(E item) {
        this.item = item;
    }
}
