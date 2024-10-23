import java.util.Scanner;
import java.util.Stack;

public class DocumentEditor_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<String> mainStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        String currentText = "";

        while (true) {
            String input = scanner.nextLine();


            if (input.equals("End")) {
                break;
            }


            if (input.startsWith("Insert(")) {

                int startIndex = input.indexOf("\"") + 1;
                int endIndex = input.lastIndexOf("\"");
                String toInsert = input.substring(startIndex, endIndex);

                mainStack.push(currentText);
                redoStack.clear();

                currentText += toInsert;
                System.out.println(currentText);
            }

            else if (input.equals("Undo()")) {
                if (!mainStack.isEmpty()) {
                    redoStack.push(currentText);
                    currentText = mainStack.pop();
                    System.out.println(currentText);
                } else {
                    System.out.println("Nothing to undo.");
                }
            }

            else if (input.equals("Redo()")) {
                if (!redoStack.isEmpty()) {
                    mainStack.push(currentText);
                    currentText = redoStack.pop();
                    System.out.println(currentText);
                } else {
                    System.out.println("Nothing to redo.");
                }
            }
        }
        scanner.close();
    }
}
