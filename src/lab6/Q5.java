package lab6;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Q5 {
    private static final Stack<Integer>[] rods = new Stack[3];
    private static final int DELAY = 800;
    private static final boolean AI = true;
    private static final boolean ITERATIVE = false;
    private static int numberOfDisks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        numberOfDisks = scanner.nextInt();
        if (numberOfDisks <= 0) throw new IllegalArgumentException();

        // Initialise the game
        for (int i = 0; i < 3; i++)
            rods[i] = new Stack<>();
        for (int i = numberOfDisks; i > 0; i--)
            rods[0].push(i);

        display();
        if (AI) {
            try {
                if (ITERATIVE) {
                    int[][] odd = {{0, 2}, {0, 1}, {1, 2}};
                    int[][] even = {{0, 1}, {0, 2}, {1, 2}};
                    int[][] moves = (numberOfDisks % 2 == 1 ? odd : even);

                    while (!hasCompleted()) {
                        for (int[] move : moves) {
                            iterative(move[0], move[1]);
                            if (hasCompleted()) break;
                        }
                    }
                } else recursive();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            while (!hasCompleted()) {
                System.out.print("Enter your move: ");
                int from = scanner.nextInt() - 1;
                int to = scanner.nextInt() - 1;
                if (!isLegalMove(from, to)) {
                    System.out.println("Invalid move.\n");
                    continue;
                }
                rods[to].push(rods[from].pop());
                display(to);
            }
        }
        System.out.println("Game Over!!!");
    }

    private static boolean isLegalMove(int from, int to) {
        if (from < 0 || from > 2 || to < 0 || to > 2) return false;
        if (rods[from].isEmpty()) return false;
        if (!rods[to].isEmpty() && rods[from].peek() > rods[to].peek()) return false;
        return true;
    }

    private static void iterative(int a, int b) throws InterruptedException {
        if (!isLegalMove(a, b) && !isLegalMove(b, a)) return;
        if (!isLegalMove(a, b)) {
            int temp = a;
            a = b;
            b = temp;
        }
        rods[b].push(rods[a].pop());
        System.out.println((char) (a + 'A') + " -> " + (char) (b + 'A'));
        display(b);
        Thread.sleep(DELAY);
    }

    private static void recursive() throws InterruptedException {
        recursive(numberOfDisks, 0, 1, 2);
    }

    private static void recursive(int n, int source, int intermediate, int target) throws InterruptedException {
        if (n == 0) return;
        recursive(n - 1, source, target, intermediate);

        rods[target].push(rods[source].pop());
        System.out.println((char) (source + 'A') + " -> " + (char) (target + 'A'));
        display(target);
        Thread.sleep(DELAY);

        recursive(n - 1, intermediate, source, target);
    }

    private static boolean hasCompleted() {
        return rods[2].size() == numberOfDisks;
    }

    private static void display() {
        display(-1);
    }

    private static void display(int target) {
        Iterator<Integer>[] iterators = new Iterator[3];
        for (int i = 0; i < 3; i++)
            iterators[i] = rods[i].iterator();

        StringBuilder s = new StringBuilder();
        for (int row = 0; row <= numberOfDisks; row++) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < iterators.length; i++) {
                Iterator<Integer> iterator = iterators[i];
                if (iterator.hasNext()) {
                    int next = iterator.next();
                    if (!iterator.hasNext() && i == target) line.append("\u001B[32m");
                    line.append(diskImage(next));
                    if (!iterator.hasNext() && i == target) line.append("\u001B[0m");
                    line.append(" ");
                } else line.append(diskImage()).append(" ");
            }
            line.append('\n');
            s.insert(0, line);
        }
        System.out.println(s);
    }

    private static String diskImage() {
        int space = 2 * numberOfDisks - 1;
        return " ".repeat(space) + "|" + " ".repeat(space);
    }

    private static String diskImage(int size) {
        int space = 2 * (numberOfDisks - size);
        return " ".repeat(space) + "=".repeat(2 * size - 1) + size + "=".repeat(2 * size - 1) + " ".repeat(space);
    }
}
