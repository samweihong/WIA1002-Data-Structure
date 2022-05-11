package lab7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Buy 100 shares at $10 each
Buy 50 shares at $20 each
Sell 50 shares at $20 each
Sell 60 shares at $30 each
Sell 50 shares at $35 each
 */

public class Q3 {
    static Queue<Integer> shareQueue = new LinkedList<>();
    static Queue<Integer> priceQueue = new LinkedList<>();
    static int totalCapitalGain = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String query = scanner.nextLine();
            if (query.equals("")) break;

            Pattern pattern = Pattern.compile("^(Buy|Sell) (\\d+) shares at \\$(\\d+) each$");
            Matcher matcher = pattern.matcher(query);
            if (!matcher.find()) {
                System.out.println("Invalid query");
                continue;
            }
            boolean isBuying = matcher.group(1).equals("Buy");
            int share = Integer.parseInt(matcher.group(2));
            int price = Integer.parseInt(matcher.group(3));

            if (isBuying) buy(share, price);
            else          sell(share, price);
        }
        System.out.println("Final Capital Gain / Loss: " + totalCapitalGain);
    }

    private static void buy(int share, int price) {
        System.out.println("Buying now...");
        shareQueue.offer(share);
        priceQueue.offer(price);
        System.out.println("Queue for Share: Queue: " + shareQueue);
        System.out.println("Queue for Price: Queue: " + priceQueue);
    }

    private static void sell(int share, int price) {
        System.out.println("Selling the shares now...");
        while (share > 0) {
            assert shareQueue.size() == priceQueue.size();
            if (shareQueue.isEmpty()) {
                System.out.println("No shares to sell!");
                break;
            }
            if (share >= shareQueue.peek()) {
                totalCapitalGain += shareQueue.peek() * (price - priceQueue.poll());
                share -= shareQueue.poll();
            } else {
                totalCapitalGain += share * (price - priceQueue.peek());
                shareQueue.offer(shareQueue.poll() - share);
                for (int i = shareQueue.size(); i > 1; i--)
                    shareQueue.offer(shareQueue.poll());
                share = 0;
            }
            System.out.println("Total Capital Gain / Loss: " + totalCapitalGain);
        }
        System.out.println("Queue for Share: Queue: " + shareQueue);
        System.out.println("Queue for Price: Queue: " + priceQueue);
    }
}
