package lab1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) {
        String[][] texts = {
                {"src/lab1/text1.txt", ","},
                {"src/lab1/text2.txt", ", "},
                {"src/lab1/text3.txt", "; "},
                {"src/lab1/text4.txt", "\\d+"},
        };
        for (String[] text : texts)
            solution(text[0], text[1]);
        for (String[] text : texts)
            solutionUsingStartsWith(text[0], text[1]);
        for (int i = 0; i < 3; i++) {
            String[] text = texts[i];
            solutionUsingStringTokenizer(text[0], text[1]);
        }
    }

    public static void solution(String filename, String regex) {
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            int characterCount = 0;
            int tokenCount = 0;
            StringBuilder res = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] strings = line.split(regex);
                tokenCount += strings.length;
                for (String s : strings) {
                    characterCount += s.length();
                    res.append(s).append('\t');
                }
                res.append('\n');
            }
            sc.close();
            System.out.println("Number of characters retrieved: " + characterCount);
            System.out.println("Number of tokens retrieved: " + tokenCount);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void solutionUsingStartsWith(String filename, String delimiter) {
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            int characterCount = 0;
            int tokenCount = 0;
            StringBuilder res = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (delimiter.equals("\\d+") && Character.isDigit(line.charAt(i))) {
                        while (i < line.length() && Character.isDigit(line.charAt(i)))
                            i++;
                        res.append('\t');
                        tokenCount++;
                    } else if (line.startsWith(delimiter, i)) {
                        i += delimiter.length();
                        res.append('\t');
                        tokenCount++;
                    }
                    if (i == line.length()) break;
                    res.append(line.charAt(i));
                    characterCount++;
                }
                tokenCount++;
                res.append('\n');
            }
            sc.close();
            System.out.println("Number of characters retrieved: " + characterCount);
            System.out.println("Number of tokens retrieved: " + tokenCount);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void solutionUsingStringTokenizer(String filename, String delimiter) {
        try {
            Scanner sc = new Scanner(new FileInputStream(filename));
            int characterCount = 0;
            int tokenCount = 0;
            StringBuilder res = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                StringTokenizer st = new StringTokenizer(line, delimiter);
                while(st.hasMoreElements()) {
                    String element = st.nextToken();
                    res.append(element).append("\t");
                    characterCount += element.length();
                    tokenCount++;
                }
                res.append('\n');
            }
            sc.close();
            System.out.println("Number of characters retrieved: " + characterCount);
            System.out.println("Number of tokens retrieved: " + tokenCount);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
