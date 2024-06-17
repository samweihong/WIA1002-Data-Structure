import java.util.Scanner;

// 5-3+4
// 2+4*5-(9+7*6)
// 9-2*(5/2-3/5+2)/6

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter expression to evaluate : ");
        String expression = sc.nextLine();
        double solution = solve(expression);
        System.out.println(expression + " = " + solution);
    }

    public static double solve(String expression) {
        expression = "(" + expression + ")";

        ExamStack<Character> operators = new ExamStack<>();
        ExamStack<Double> operands = new ExamStack<>();

        for (char c : expression.toCharArray()) {
            switch (c) {
                case '(' -> operators.push(c);
                case ')' -> {
                    while (operators.getSize() > 0 && operators.peep() != '(') {
                        solveLast(operators, operands);
                    }
                    operators.pop();
                }
                case '*', '/' -> {
                    while (operators.getSize() > 0 && (operators.peep() == '*' || operators.peep() == '/')) {
                        solveLast(operators, operands);
                    }
                    operators.push(c);
                }
                case '+', '-' -> {
                    while (operators.getSize() > 0 && operators.peep() != '(') {
                        solveLast(operators, operands);
                    }
                    operators.push(c);
                }
                default -> operands.push((double) Character.getNumericValue(c));
            }
        }
        return operands.peep();
    }

    private static void solveLast(ExamStack<Character> operators, ExamStack<Double> operands) {
        double sec = operands.pop();
        double fir = operands.pop();
        char op = operators.pop();

        double result = 0;
        switch (op) {
            case '+' -> result = fir + sec;
            case '-' -> result = fir - sec;
            case '*' -> result = fir * sec;
            case '/' -> result = fir / sec;
        }
        operands.push(result);
    }
}
