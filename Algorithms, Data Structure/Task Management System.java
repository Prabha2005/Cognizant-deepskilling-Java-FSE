import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class TaskManager {
    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    public void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task prev = null, current = head;
        while (current != null && current.taskId != id) {
            prev = current;
            current = current.next;
        }
        if (current != null) prev.next = current.next;
    }

    public void displayTasks() {
        Task current = head;
        if (current == null) {
            System.out.println("No tasks found.");
            return;
        }
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task\n2. Delete Task\n3. Search Task\n4. Display Tasks\n5. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    tm.addTask(id, name, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    tm.deleteTask(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    Task t = tm.searchTask(searchId);
                    if (t != null) {
                        System.out.println("Found - Task ID: " + t.taskId + ", Name: " + t.taskName + ", Status: " + t.status);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 4:
                    tm.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}