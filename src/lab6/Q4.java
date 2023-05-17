package lab6;

import java.util.Stack;

public class Q4 {
    public static void main(String[] args) {
        String[] inputs = {"T_T", "abcba", "uvvwu", "xyzzyx", "pppqpp"};
        for (String input : inputs)
            System.out.printf("%s is palindrome: %b\n", input, isPalindrome(input));
    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            stack.push(c);
        for (char c : s.toCharArray())
            if (c != stack.pop()) return false;
        return true;
    }
}
