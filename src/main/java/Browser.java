import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        String current = null;

        while (!command.equals("Home")){
            if (command.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    current = stack.pop();
                    System.out.println(current);
                }
            }else {
                if (current!=null){
                    stack.push(current);
                }
                current = command;
                System.out.println(current);
            }

            command = scanner.nextLine();
        }

    }
}
