package lab6;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer value: ");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++)
            stack.push(i);

        System.out.println("Size of the stack: " + stack.getSize());

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();

        // Answers:
        // Output: n = user entered value n-1 n-2 ... 2 1
        // Order: Descending order
        // Reason: Stack is a last in, first out data structure.
        //         Therefore, the larger numbers are popped first as they are pushed later than the smaller numbers.
    }
}
