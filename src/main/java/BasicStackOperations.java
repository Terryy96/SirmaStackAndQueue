import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numberOfElements = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int numberOfElementsToPop = numberOfElements[1];
        int checkIfPresent = numberOfElements[2];

        for (int number : numbers) {
            stack.push(number);
        }
        for (int i = 0; i < numberOfElementsToPop; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        if (numbers.contains(checkIfPresent)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                int minElement = stack.stream().min(Integer::compareTo).get();
                System.out.println(minElement);
            }
        }

    }
}
// If it
//is present, print "true" on the console. If it's not, print the smallest element currently
//present in the stack.
// On the first line, you will be given N, S, and X separated by a single space.

// On a single line print, either "true" if X is present in the stack, otherwise, print
//the smallest element in the stack.
// If the stack is empty – print 0.