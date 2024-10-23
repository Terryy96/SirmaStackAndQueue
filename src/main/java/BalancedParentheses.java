import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static boolean checkParentheses(String check) {

        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < check.length(); i++) {
            if (check.charAt(i) == '(' || check.charAt(i) == '{' || check.charAt(i) == '[') {
                queue.push(check.charAt(i));
            } else {
                if (!queue.isEmpty() &&
                        ((queue.peek() == '(' && check.charAt(i) == ')') ||
                                (queue.peek() == '{' && check.charAt(i) == '}') ||
                                (queue.peek() == '[' && check.charAt(i) == ']'))) {
                    queue.pop();
                } else {
                    return false; // Unmatched closing bracket
                }
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (checkParentheses(input)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }

}
