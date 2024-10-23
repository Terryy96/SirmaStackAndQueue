import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!command.equals("print")) {
            if (command.equals("cancel")) {

                if (queue.isEmpty()) {
                    System.out.println("Standby");

                } else {
                    String canceledFile = queue.pollFirst();
                    System.out.println("Canceled " + canceledFile);
                }
            } else {
                queue.offer(command);
            }
            command = scanner.nextLine();

        }
        scanner.close();

       // System.out.println(queue.pollFirst());
        while(!queue.isEmpty()){
        String element = queue.pollFirst();
            System.out.println(element);
         }
    }
}
