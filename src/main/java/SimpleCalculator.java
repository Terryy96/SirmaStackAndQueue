import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String [] parts = input.split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(parts[0]));


        for (int i = 1; i <parts.length ; i+=2) {
            String operator  = parts[i];
            int number = Integer.parseInt(parts[i + 1]);

            if (operator.equals("+")){
                stack.push(number);
            }else if (operator.equals("-")){
                stack.push(-number);
            }
        }
        int result = 0;

        while (!stack.isEmpty()){
            result+=stack.pop();
        }

        System.out.println(result);

    }
}
