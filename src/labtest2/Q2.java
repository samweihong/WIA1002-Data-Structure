package labtest2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        boolean noteIsSeen = false;
        Stack<String> stack = new Stack<>();
        try {
            Scanner input = new Scanner(new FileInputStream("test.xml"));
            System.out.println("Contents of XML file");
            String document = "";
            // Read all lines and stores it in document without line breaks;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
                document += line;
            }
            input.close();

            for (int i = 0; i < document.length(); i++) {
                if (document.charAt(i) == '<') {
                    int closingChar = document.indexOf('>', i);
                    // If there is no '>' to close the tag, display the error.
                    if (closingChar == -1) {
                        System.out.println("No closing character '>'!");
                        return;
                    }
                    // If the next character is /, which implies an ending element,
                    if (document.charAt(i + 1) == '/') {
                        // Extract the element name between </ and >.
                        String endingElement = document.substring(i+2, closingChar);
                        // If there is no begin element to match, display the error.
                        if (stack.isEmpty()) {
                            System.out.println("No begin element to match!");
                            return;
                        }
                        // The begin element should be at the top of the stack.
                        String beginElement = stack.pop();
                        // If the begin-end elements do not match, display the error.
                        if (!beginElement.equals(endingElement)) {
                            System.out.println("Begin Element : <" + beginElement + "> Invalid ending element : </" + endingElement + ">");
                            return;
                        }
                    } else {
                        // Otherwise, if this is a begin element,
                        // Extract the element name between < and >.
                        String beginElement = document.substring(i+1, closingChar);
                        if (beginElement.equals("note")) {
                            // If the "note" element is seen before, display the error.
                            if (noteIsSeen) {
                                System.out.println("Duplicate root element <note>");
                                return;
                            }
                            // Otherwise, set the "note" element to be seen.
                            noteIsSeen = true;
                        }
                        stack.push(beginElement);
                    }
                    // Skip the cursor to after the '>' character.
                    i = closingChar;
                }
            }
            // If there are unmatched begin elements in the stack, display the error.
            if (!stack.isEmpty())
                System.out.println("Not all begin element is matched!");
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }
    }
}
