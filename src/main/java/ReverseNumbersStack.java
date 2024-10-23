import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 1; i <=arr.length ; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
