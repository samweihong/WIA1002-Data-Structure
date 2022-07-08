package exam;

import java.util.Random;

public class LuckyDraw {
    public static void main(String[] args) {
        LinkedList<Staff> staffList1 = new LinkedList<>();
        staffList1.addLast(new Staff(1, "Luke Skywalker", "Manager"));
        staffList1.addLast(new Staff(2, "Han Solo", "Supervisor"));
        staffList1.addLast(new Staff(6, "Moff Tarkin", "Assistant"));
        staffList1.addLast(new Staff(8, "Obi Wan", "Assistant"));
        staffList1.addLast(new Staff(9, "Organa", "Assistant"));
        staffList1.addLast(new Staff(12, "Leia Organa", "Supervisor"));
        staffList1.addLast(new Staff(15, "Chewbacca", "Assistant"));
        staffList1.addLast(new Staff(16, "Uncle Owen", "Assistant"));
        staffList1.addLast(new Staff(17, "Aunt Beru", "Assistant"));
        staffList1.addLast(new Staff(19, "Lando Calrissian", "Assistant"));

        LinkedList<Staff> staffList2 = staffList1.clone();

        firstRound(staffList1, 5);
        System.out.println();
        secondRound(staffList2, 1000);
    }

    // This method is efficient unless the number of elements in list >> number of winners to choose
    public static void firstRound(LinkedList<Staff> list, int n) {
        int[] numbers = new int[list.getSize()];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i;

        // Shuffle the numbers randomly and manually
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            // Swap numbers[i] with random element in numbers[i..N-1]
            int randomIndex = random.nextInt(numbers.length - i) + i;
            int temp = numbers[i];
            numbers[i] = numbers[randomIndex];
            numbers[randomIndex] = temp;
        }

        // Choose the first n elements in the list
        for (int i = 0; i < n; i++) {
            Staff winner = list.get(numbers[i]);
            System.out.println(winner.getID() + " " + winner.getName() + " wins a drone!");
        }
    }

    public static void secondRound(LinkedList<Staff> list, int prize) {
        Random random = new Random();
        while (prize > 0) {
            int i = random.nextInt(list.getSize());
            Staff winner = list.get(i);

            if (winner.getPosition().equalsIgnoreCase("Manager")) {
                System.out.println("Manager " + winner.getName() + " is the winner, but no cash voucher will be given");
            } else {
                int voucher = 0;
                if (winner.getPosition().equalsIgnoreCase("Assistant"))
                    voucher = 200;
                else if (winner.getPosition().equalsIgnoreCase("Supervisor"))
                    voucher = 100;

                voucher = Math.min(voucher, prize);

                prize -= voucher;

                System.out.println(winner.getPosition() + " " + winner.getName() + " wins RM" + voucher +
                                   ". Cash vouchers left RM" + prize);
            }
        }
    }
}
