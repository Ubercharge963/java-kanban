import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TaskManager {
    HashMap<Integer, Task> listTask;
    HashMap<Integer, Epic> listEpic;
    HashMap<Integer, SubTask> listSubTask;

    protected int taskId = 0;
    protected int epicId = 0;
    protected int subTaskId = 0;

    public TaskManager() {
        listTask = new HashMap<>();
        listEpic = new HashMap<>();
        listSubTask = new HashMap<>();
    }
    public ArrayList<Task> getListTask() {          // получение списка задач
        return new ArrayList<>(listTask.values());
    }
    public ArrayList<Epic> getListEpic() {          // получение списка эпиков
        return new ArrayList<>(listEpic.values());
    }
    public ArrayList<SubTask> getListSubTask() {    // получение списка подзадач
        return new ArrayList<>(listSubTask.values());
    }
    public void clearTask() {       //удалить задачу
        listTask.clear();
    }
    public void clearEpic() {       // удалить эпик
        listSubTask.clear();
        listEpic.clear();
    }
    public void clearSubTask() {    //  удалить подзадачу
        listSubTask.clear();
    }
    public Task getTaskById(Task task) {    // получение задачи по id
        return listTask.get(task.getId());
    }
    public Epic getEpicById(Epic epic) {    // получение эпика по id
        return listEpic.get(epic.getId());
    }
    public SubTask getSubTaskById(SubTask subTask) {     // получение подзадачи по id
        return listSubTask.get(subTask.getId());
    }
    public void addTask(Task task) { //+задача
        listTask.put(++taskId, task);
        task.setStatus(StatusOfTask.DONE);
    }
    public void addEpic(Epic epic) {    //+ эпик
        listEpic.put(++epicId, epic);
    }
    public void addSubTask(SubTask subTask) {   //+подзадача
        listSubTask.put(++subTaskId, subTask);
        subTask.setStatus(StatusOfTask.DONE);
   }
    public void updateTask(Task task) {     // изменение задачи
        clearTask();
        listTask.put(task.getId(), task);
    }
    public void updateEpic(Epic epic) {     // изменение эпика
        clearEpic();
        listEpic.put(epic.getId() ,epic);
    }
    public void updateSubTask(SubTask subTask) {    // изменение подзадачи
        clearSubTask();
        listSubTask.put(subTask.getId(), subTask);
    }
    public void removeTaskById (Task task) {    // удаление задачи по id
        listTask.remove(task.getId(), task);
    }
    public void removeEpicById (Epic epic) {    // удаление эпика по id
        listTask.remove(epic.getId(), epic);
    }
    public void removeSubTaskById (SubTask subTask) {   // удаление подзадачи по id
        listTask.remove(subTask.getId(), subTask);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TaskManager that = (TaskManager) object;
        return taskId == that.taskId && epicId == that.epicId && subTaskId == that.subTaskId && Objects.equals(listTask, that.listTask) && Objects.equals(listEpic, that.listEpic) && Objects.equals(listSubTask, that.listSubTask);
    }
    @Override
    public int hashCode() {
        return Objects.hash(listTask, listEpic, listSubTask, taskId, epicId, subTaskId);
    }
}
