package lab1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        solution("src/lab1/text1.txt", ",");
        solution("src/lab1/text2.txt", ", ");
        solution("src/lab1/text3.txt", "; ");
        solution("src/lab1/text4.txt", "\\d+");
        solutionWithoutLibrary("src/lab1/text1.txt", ",");
        solutionWithoutLibrary("src/lab1/text2.txt", ", ");
        solutionWithoutLibrary("src/lab1/text3.txt", "; ");
        solutionWithoutLibrary("src/lab1/text4.txt", "\\d+");
    }

    public static void solution(String filename, String regex) {
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            int sum = 0;
            StringBuilder res = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] strings = line.split(regex);
                for (String s : strings) {
                    sum += s.length();
                    res.append(s);
                }
                res.append('\n');
            }
            sc.close();
            System.out.println("Number of characters retrieved: " + sum);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void solutionWithoutLibrary(String filename, String regex) {
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            int sum = 0;
            String res = "";
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if ("\\d+".equals(regex) && Character.isDigit(line.charAt(i)))
                        continue;
                    else if (line.startsWith(regex, i)) {
                        i += regex.length() - 1;
                        continue;
                    }
                    res += line.charAt(i);
                    sum++;
                }
                res += '\n';
            }
            sc.close();
            System.out.println("Number of characters retrieved: " + sum);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
