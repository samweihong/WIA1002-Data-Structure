package tutorial7a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner keyIn = new Scanner(System.in);
        for (int i = 1; i <= 5; i++)
        {
            if (keyIn.nextBoolean())
                System.out.print(i + " ");
            else
                q.offer(i);
        }
        while (!q.isEmpty())
            System.out.print(q.poll() + " ");
        System.out.println();
    }
}

// Answers:
// (a)
// 1 4 5 2 3
//
// true - 1 is printed
// false - 2 is enqueued.
// false - 3 is enqueued.
// true - 4 is printed
// true - 5 is printed
//
// Queue = [2, 3]
// 2 and 3 is printed.
//
// (b)
// Not possible to have output 1 3 5 4 2
//
// 1 is printed
// 2 is not printed but instead enqueued
// 3 is printed
// 4 is not printed but instead enqueued
// 5 is printed
//
// Queue = [2, 4]
// 2 and 4 will be printed.
// Hence, it is impossible to print 4 2.
//
// (c)
// true true true true true
// false false false false false
// true true true true false
