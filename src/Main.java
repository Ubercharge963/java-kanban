public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Task  1   ", "  SimpleTask  1  ");
        Task task2 = new Task("Task  2   ", "  SimpleTask  2  ");
        Epic epic1 = new Epic("Epic N1", "  Contains:");
        SubTask subTack1 = new SubTask("Subtask 1", " Subtask 1 description");
        SubTask subTack2 = new SubTask("Subtask 2", "  Subtask 2 description");

        Epic epic2 = new Epic("Epic N2", "   Contains:");
        SubTask subTack11 = new SubTask("Subtask 11", "  Subtask 11 description");

        System.out.println(task1);
        System.out.println(task2);
        System.out.println(epic1);
        System.out.println(subTack1);
        System.out.println(subTack2);
        System.out.println(epic2);
        System.out.println(subTack11);

        epic1.calculateEpicStatus(epic1);
    }
}
