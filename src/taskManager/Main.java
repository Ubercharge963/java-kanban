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
        Epic epic1 = new Epic("Epic N1", "  Epic 1");
        SubTask subTask1 = new SubTask("Subtask 1", " Subtask 1 description", StatusOfTask.DONE);
        SubTask subTask2 = new SubTask("Subtask 2", "  Subtask 2 description", StatusOfTask.NEW);
        taskManager.addEpic(epic1);
        subTask1.setEpicId(3);
        subTask2.setEpicId(3);
        taskManager.addSubTask(subTask1);
        taskManager.addSubTask(subTask2);
        Epic epic2 = new Epic("Epic N2", "   Epic 2  ");
        taskManager.addEpic(epic2);
        SubTask subTask3 = new SubTask("Subtask 3", "  Subtask 3 description", StatusOfTask.DONE);
        subTask3.setEpicId(6);
        taskManager.addSubTask(subTask3);
        //Распечатайте списки эпиков, задач и подзадач

        System.out.println("Список задач: \n" + taskManager.getListTask());
        System.out.println("Список подзадач : \n" + taskManager.getListSubTask());
        System.out.println("Список эпиков : \n" + taskManager.getListEpic());

        //Измените статусы созданных объектов, распечатайте их.
        // Проверьте, что статус задачи и подзадачи сохранился,
        // а статус эпика рассчитался по статусам подзадач.

        subTask2.setStatus(StatusOfTask.DONE);
        System.out.println(subTask2);
        subTask3.setStatus(StatusOfTask.NEW);
        System.out.println(subTask3);
        taskManager.updateEpic(epic1);
        taskManager.updateEpic(epic2);
        System.out.println(epic1);
        System.out.println(epic2);

        //попробуйте удалить одну из задач и один из эпиков.
        taskManager.removeSubTaskById(4);
        taskManager.removeTaskById(2);
        System.out.println("Список задач: \n" + taskManager.getListTask());
        taskManager.removeEpicById(6);
        System.out.println("Список эпиков : \n" + taskManager.getListEpic());
        System.out.println("Список подазадач в эпике 2: \n" + taskManager.getEpicSubtaskList(3));


    }
}
