import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatchingBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i <input.length() ; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '('){
                stack.push(i);
            } else if (currentChar == ')') {
                int startIndex = stack.pop();
                int endIndex = i;
                String subExpression = input.substring(startIndex, endIndex + 1);
                System.out.println(subExpression);
            }
        }
    }

    public static class DocumentEditor_13 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            ArrayDeque<String> queue = new ArrayDeque<>();
            ArrayDeque<String> queue2 = new ArrayDeque<>();


            while (!input.equals("End")){

                List<String> items = Arrays.stream(input.split(" "))
                        .collect(Collectors.toList());
                int startIndex = input.indexOf("\"") + 1;
                int endIndex = input.lastIndexOf("\"");
                String name = input.substring(startIndex, endIndex);
                //String name = items.get(1);
                System.out.println(name);

                 if (input.contains("Insert")){
                     queue.offer(name);
                     queue2.offer(name);
                     System.out.print(queue.toString());
                 } else if (input.contains("Undo")) {
                     String lastTask = queue.pop();
                     queue2.push(lastTask);
                     System.out.print(queue);
                 }else if (input.contains("Redo")) {
                     String lastUndone = queue2.pop();  // Get the last undone task
                     queue.offer(lastUndone);
                     System.out.print(queue);
                 }
                input = scanner.nextLine();
            }
        }
    }
}
