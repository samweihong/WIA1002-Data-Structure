package lab11;

import java.util.ArrayList;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;
    private int size = 0;

    public boolean search(E e) {
        for (TreeNode<E> current = root; current != null; ) {
            if (e.compareTo(current.element) == 0)
                return true;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        return false;
    }

    public boolean insert(E e) {
        if (root == null)
            root = new TreeNode<>(e);
        else {
            TreeNode<E> parent = null;
            for (TreeNode<E> current = root; current != null; ) {
                if (e.compareTo(current.element) == 0)
                    return false;
                parent = current;
                current = e.compareTo(current.element) < 0 ? current.left : current.right;
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = new TreeNode<>(e);
            else
                parent.right = new TreeNode<>(e);
        }
        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E getRoot() {
        return root.element;
    }

    public E minValue() {
        E min = null;
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            if (current == null) continue;
            if (min == null || current.element.compareTo(min) < 0)
                min = current.element;
            stack.push(current.left);
            stack.push(current.right);
        }
        return min;
    }

    public E maxValue() {
        E max = null;
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.pop();
            if (current == null) continue;
            if (max == null || current.element.compareTo(max) > 0)
                max = current.element;
            stack.push(current.left);
            stack.push(current.right);
        }
        return max;
    }

    public ArrayList<TreeNode<E>> path(E e) {
        if (root == null) return null;

        ArrayList<TreeNode<E>> path = new ArrayList<>();
        for (TreeNode<E> current = root; current != null; ) {
            path.add(current);
            if (current.element == e) break;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        return path.get(path.size() - 1).element == e ? path : null;
    }

    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) == 0) break;
            parent = current;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        if (current == null) return false;

        if (current.left == null) {
            if (parent == null)
                root = current.right;
            else if (e.compareTo(parent.element) < 0)
                parent.left = current.right;
            else
                parent.right = current.right;
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.left == rightMost)
                parentOfRightMost.left = rightMost.left;
            else
                parentOfRightMost.right = rightMost.left;
        }
        size--;
        return true;
    }

    public boolean clear() {
        root = null;
        size = 0;
        return true;
    }

    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

