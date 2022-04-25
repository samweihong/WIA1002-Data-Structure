package lab6;

import java.util.Stack;

public class Q4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("T_T"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("uvvwu"));
        System.out.println(isPalindrome("xyzzyx"));
        System.out.println(isPalindrome("pppqpp"));
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
