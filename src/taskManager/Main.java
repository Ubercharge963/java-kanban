package taskManager;

import taskManager.model.Epic;
import taskManager.model.SubTask;
import taskManager.model.Task;
import taskManager.sevice.TaskManager;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Task  1   ", "  SimpleTask  1  ");
        Task task2 = new Task("Task  2   ", "  SimpleTask  2  ");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        Epic epic1 = new Epic("Epic N1", "  Contains:");
        SubTask subTask1 = new SubTask("Subtask 1", " Subtask 1 description");
        SubTask subTask2 = new SubTask("Subtask 2", "  Subtask 2 description");
        taskManager.addEpic(epic1);
        taskManager.addSubTask(subTask1, epic1);
        taskManager.addSubTask(subTask2,epic1);
        Epic epic2 = new Epic("Epic N2", "   Contains:");
        SubTask subTask11 = new SubTask("Subtask 11", "  Subtask 11 description");
        taskManager.addSubTask(subTask11,epic2);
        System.out.println (taskManager.getListTask());
        System.out.println (taskManager.getListSubTask());
        System.out.println (taskManager.getListEpic());


    }
}
