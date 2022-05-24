package labtest2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // Create two queues to store the product codes and the category queues.
        Queue<String> productCodes = new Queue<>();
        Queue<Queue<String>> queues = new Queue<>();

        readInput(productCodes, queues);
        printAll(productCodes, queues);
    }
    public static void readInput(Queue<String> productCodes, Queue<Queue<String>> queues) {
        try {
            Scanner input = new Scanner(new FileInputStream("labtest2.txt"));
            while (input.hasNextLine()) {
                String[] words = input.nextLine().split(" ");
                for (int i = 0; i < words.length; i++) {
                    // If the product code is in the queue,
                    if (productCodes.contains(words[i])) {
                        // Stores the product name in the respective queue.
                        int index = productCodes.indexOf(words[i]);
                        queues.get(index).enqueue(words[++i]);
                    } else {
                        // Otherwise, stores this new product code in the queue.
                        productCodes.enqueue(words[i]);
                        // Create a new queue with the product name and stores it.
                        Queue<String> q = new Queue<>();
                        q.enqueue(words[++i]);
                        queues.enqueue(q);
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }
    }

    // Print the output as the sample output.
    public static void printAll(Queue<String> productCodes, Queue<Queue<String>> queues) {
        System.out.println("Product Code in Queue : " + productCodes);
        System.out.println("List of products by categories");
        for (int i = 0; i < productCodes.getSize(); i++) {
            System.out.println("Product : " + productCodes.get(i));
            System.out.println(queues.get(i));
        }
    }
}
