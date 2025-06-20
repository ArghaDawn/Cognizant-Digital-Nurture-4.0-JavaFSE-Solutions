public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTask(new Task(1, "Design Module", "Pending"));
        taskList.addTask(new Task(2, "Implement Feature", "In Progress"));
        taskList.addTask(new Task(3, "Test Application", "Pending"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task found = taskList.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        System.out.println("\nDeleting Task with ID 1:");
        boolean deleted = taskList.deleteTask(1);
        System.out.println(deleted ? "Task deleted." : "Task not found.");

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();

        System.out.println("\n--- Analysis ---");
        System.out.println("Time Complexity of Operations in Singly Linked List:");
        System.out.println("- Add Task (at end): O(n)");
        System.out.println("- Search Task: O(n)");
        System.out.println("- Traverse Tasks: O(n)");
        System.out.println("- Delete Task: O(n)\n");
        System.out.println("Advantages of Linked Lists over Arrays for Dynamic Data:");
        System.out.println("- Dynamic Size: Linked lists can grow or shrink at runtime, while arrays have a fixed size.");
        System.out.println("- Efficient Insertions/Deletions: Adding or removing elements is more efficient, as it only involves updating pointers, not shifting elements.");
        System.out.println("- No Memory Wastage: No need to allocate extra space in advance as with arrays.");
    }
}
