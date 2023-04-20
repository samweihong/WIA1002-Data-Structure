package lab5.SList;

public class SNode<E> {
    E item;
    SNode<E> next;

    public SNode() {
    }

    public SNode(E item) {
        this.item = item;
    }
}
