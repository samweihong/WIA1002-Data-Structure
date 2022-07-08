package exam;

import java.util.List;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Stack<String> data1 = new Stack<>();
        data1.addAll(List.of("Switch", "Motherboard", "RAM", "SSD", "CPU", "GPU", "Router"));
        System.out.println("Before reverse: " + data1);
        reverse(data1);
        System.out.println("After reverse: " + data1);

        System.out.println();

        Stack<Integer> data2 = new Stack<>();
        data2.addAll(List.of(17, 21, 45, 23, 1, 99, 16));
        System.out.println("Before reverse: " + data2);
        reverse(data2);
        System.out.println("After reverse: " + data2);
    }

    public static <E> void reverse(Stack<E> stack) {
        if (stack.isEmpty()) return;
        E e = stack.pop();
        reverse(stack);
        insertAtBottom(stack, e);
    }

    public static <E> void insertAtBottom(Stack<E> stack, E e) {
        if (stack.isEmpty()) {
            stack.push(e);
            return;
        }
        E temp = stack.pop();
        insertAtBottom(stack, e);
        stack.push(temp);
    }
}
