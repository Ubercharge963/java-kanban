package taskManager;

import taskManager.model.Epic;
import taskManager.model.StatusOfTask;
import taskManager.model.SubTask;
import taskManager.model.Task;
import taskManager.sevice.TaskManager;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        //Создайте две задачи, а также эпик с двумя подзадачами и эпик с одной подзадачей.

        Task task1 = new Task("Task  1   ", "  SimpleTask  1  ", StatusOfTask.NEW);
        Task task2 = new Task("Task  2   ", "  SimpleTask  2  ", StatusOfTask.DONE);
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        Epic epic1 = new Epic("Epic N1", "  Epic 1",StatusOfTask.IN_PROGRESS);
        SubTask subTask1 = new SubTask("Subtask 1", " Subtask 1 description", StatusOfTask.DONE);
        SubTask subTask2 = new SubTask("Subtask 2", "  Subtask 2 description", StatusOfTask.NEW);
        taskManager.addEpic(epic1);
        taskManager.addSubTask(subTask1);
        taskManager.addSubTask(subTask2);
        epic1.addSubTaskToEpic(subTask1,epic1);
        epic1.addSubTaskToEpic(subTask2,epic1);
        Epic epic2 = new Epic("Epic N2", "   Epic 2  ", StatusOfTask.DONE);
        taskManager.addEpic(epic2);
        SubTask subTask11 = new SubTask("Subtask 11", "  Subtask 11 description", StatusOfTask.DONE);
        taskManager.addSubTask(subTask11);
        epic2.addSubTaskToEpic(subTask11,epic2);
        //Распечатайте списки эпиков, задач и подзадач

        System.out.println ("Список задач: \n" +taskManager.getListTask());
        System.out.println ("Список подзадач : \n" +taskManager.getListSubTask());
        System.out.println ("Список эпиков : \n" +taskManager.getListEpic());

        //Измените статусы созданных объектов, распечатайте их.
        // Проверьте, что статус задачи и подзадачи сохранился,
        // а статус эпика рассчитался по статусам подзадач.

        subTask2.setStatus(StatusOfTask.DONE);
        System.out.println (subTask2);
        subTask11.setStatus(StatusOfTask.IN_PROGRESS);
        System.out.println (subTask11);
        taskManager.updateEpic(epic1);
        taskManager.updateEpic(epic2);
        System.out.println (epic1);
        System.out.println (epic2);

        //попробуйте удалить одну из задач и один из эпиков.

        taskManager.removeTaskById(2);
        System.out.println ("Список задач: \n" + taskManager.getListTask());
        taskManager.removeEpicById(6);
        System.out.println ("Список эпиков : \n" + taskManager.getListEpic());
    }
}
