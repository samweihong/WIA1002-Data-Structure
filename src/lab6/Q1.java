package lab6;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        TestMyStack.main(args);
    }
}

class MyStack<E> {
    private ArrayList<E> list = new ArrayList<>();
    private int size = 0;

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        return list.remove(list.size()-1);
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public boolean search(E o) {
        for (E e : list)
            if (e.equals(o))
                return true;
        return false;
    }
}

class TestMyStack {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        for (char c = 'a'; c <= 'c'; c++)
            stack.push(c);
        System.out.println(stack);
        System.out.println("'b' is in the stack: " + stack.search('b'));
        System.out.println("'k' is in the stack: " + stack.search('k'));
        System.out.println();

        MyStack<Integer> stack2 = new MyStack<>();
        for (int i = 1; i <= 3; i++)
            stack2.push(i);
        System.out.println(stack2);
        System.out.println("'6' is in the stack: " + stack2.search(6));
    }
}
