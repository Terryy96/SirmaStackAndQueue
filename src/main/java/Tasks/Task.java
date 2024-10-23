package Tasks;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " - " + priority;
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return Integer.compare(t2.priority, t1.priority);
    }
}

class TaskManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());

        while (sc.hasNext()) {
            String command = sc.next();

            if (command.equals("Add")) {
                String taskName = sc.next();
                int priority = sc.nextInt();
                taskQueue.add(new Task(taskName, priority));

            } else if (command.equals("getNextTask")) {
                if (!taskQueue.isEmpty()) {
                    Task nextTask = taskQueue.poll();
                    System.out.println(nextTask);
                } else {
                    System.out.println("No tasks available.");
                }
            }
        }

        sc.close();
    }
}
//Create a PriorityQueue to manage tasks. Each task has a name and a priority. Implement
//the getNextTask function to get the next task with the highest priority.