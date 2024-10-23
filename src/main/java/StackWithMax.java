import java.util.*;
import java.util.stream.Collectors;


 public class StackWithMax {
        static Stack<Integer> mainStack = new Stack<Integer>();
        static Stack<Integer> trackStack = new Stack<Integer>();

        static void push(int x) {
            mainStack.push(x);
            if (mainStack.size() == 1) {
                trackStack.push(x);
                return;
            }
            if (x > trackStack.peek())
                trackStack.push(x);
            else
                trackStack.push(trackStack.peek());
        }

        static int getMax() {
            return trackStack.peek();
        }

        static void pop() {
            mainStack.pop();
            trackStack.pop();

    }


    public static void main(String[] args) {
        StackWithMax stack = new StackWithMax();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i <n ; i++) {
            List<Integer> commands = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            int command = commands.get(0);
            if (command == 1){
                int number = commands.get(1);
                StackWithMax.push(number);
            } else if (command == 2) {
                StackWithMax.pop();
            } else if (command == 3) {
                System.out.println(StackWithMax.getMax());
            }
        }
    }
}