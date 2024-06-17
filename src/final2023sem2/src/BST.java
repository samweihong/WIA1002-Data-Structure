public class BST<E extends Comparable<E>> {
    private class Node {
        E el;
        Node left;
        Node right;

        Node(E el) {
            this.el = el;
        }
    }

    private Node root;

    public void insert(E el) {
        if (root == null) {
            root = new Node(el);
            return;
        }

        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (el.compareTo(cur.el) == 0) return;

            parent = cur;
            cur = el.compareTo(cur.el) < 0 ? cur.left : cur.right;
        }

        if (el.compareTo(parent.el) < 0) {
            parent.left = new Node(el);
        } else {
            parent.right = new Node(el);
        }
    }

    public boolean delete(E el) {
        if (root == null) return false;

        Node toRemove = root;
        Node toRemoveParent = null;
        while (toRemove != null) {
            if (el.compareTo(toRemove.el) == 0) break;

            toRemoveParent = toRemove;
            toRemove = el.compareTo(toRemove.el) < 0 ? toRemove.left : toRemove.right;
        }

        if (toRemove == null) return false;

        if (toRemove.right == null) { // no right subtree
            if (toRemoveParent == null) { // toRemove is root
                root = toRemove.left;
            } else if (toRemove == toRemoveParent.left) { // attach left subtree to right position
                toRemoveParent.left = toRemove.left;
            } else {
                toRemoveParent.right = toRemove.left;
            }
        } else {
            Node toReplace = toRemove.right; // find the leftmost (smallest) node in right subtree
            Node toReplaceParent = toRemove;
            while (toReplace.left != null) {
                toReplaceParent = toReplace;
                toReplace = toReplace.left;
            }

            toRemove.el = toReplace.el;
            // since toReplace has no left subtree, just need to attach its right subtree to right position
            if (toReplace == toReplaceParent.left) {
                toReplaceParent.left = toReplace.right;
            } else {
                toReplaceParent.right = toReplace.right;
            }
        }
        return true;
    }

    public CircularDoublyLinkedList<E> toCircularDoublyLinkedList() {
        return toCircularDoublyLinkedList(root);
    }

    private CircularDoublyLinkedList<E> toCircularDoublyLinkedList(Node root) {
        if (root == null) return new CircularDoublyLinkedList<>();

        CircularDoublyLinkedList<E> leftSublist = toCircularDoublyLinkedList(root.left);
        CircularDoublyLinkedList<E> rightSublist = toCircularDoublyLinkedList(root.right);

        leftSublist.addLast(root.el);
        leftSublist.append(rightSublist);
        return leftSublist;
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node cur) {
        if (cur == null) return;
        System.out.print(cur.el + " ");
        preorder(cur.left);
        preorder(cur.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node cur) {
        if (cur == null) return;
        inorder(cur.left);
        System.out.print(cur.el + " ");
        inorder(cur.right);
    }
}
