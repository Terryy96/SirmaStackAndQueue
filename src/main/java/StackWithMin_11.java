import java.util.*;
import java.util.stream.Collectors;

public class StackWithMin_11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        List<Integer> commands = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int numberToAdd = commands.get(0);
        int numberToRemove = commands.get(1);
        int checkIfPresent = commands.get(2);


        queue.offer(numberToAdd);
        queue.pop();
        queue.addAll(numbers);

        if (queue.contains(checkIfPresent)){
            System.out.println("true");
        }else {
            int min = Integer.MAX_VALUE;
            for (int num : queue) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println(min);
        }

    }
}
//You will be given an integer N representing the number of elements to enqueue (add), an
//integer S representing the number of elements to dequeue (remove/poll) from the queue,
//and finally, an integer X, an element that you should check whether is present in the
//queue. If it is - prints true on the console, if it is not - print the smallest element currently
//present in the queue.