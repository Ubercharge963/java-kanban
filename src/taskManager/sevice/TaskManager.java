package taskManager.sevice;

import taskManager.model.Epic;
import taskManager.model.SubTask;
import taskManager.model.Task;

import java.util.ArrayList;
import java.util.HashMap;


public class TaskManager {
    protected HashMap<Integer,  Task> listTask;
    protected HashMap<Integer, Epic> listEpic;
    protected HashMap<Integer, SubTask> listSubTask;
    protected  ArrayList<SubTask> epicSubTask;


    protected StatusOfTask status;
    protected static int taskIdCounter = 0;

    public TaskManager() {
        this.listTask = new HashMap<>();
        this.listEpic = new HashMap<>();
        this.listSubTask = new HashMap<>();
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

    public void clearTask() {       //удалить все задачы

        listTask.clear();
    }

    public void clearEpic() {       // удалить все эпики
        listSubTask.clear();
        listEpic.clear();
    }

    public void clearSubTask() {    // удалить все подаздачи
        listSubTask.clear();
        for (int id : listEpic.keySet()) {
            listSubTask.clear();
            calculateEpicStatus(getEpicById(listEpic.get(id)));
        }

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

    public void addTask(Task task) {  //+задача
        listTask.put(++taskIdCounter, task);
        task.setStatus(StatusOfTask.NEW);
        task.setId(taskIdCounter);
    }

    public void addEpic(Epic epic) {    //+ эпик
        listEpic.put(++taskIdCounter, epic);
    }

    public void addSubTask(SubTask subTask, Epic epic) {   //+подзадача
        listSubTask.put(++taskIdCounter, subTask);
        epic.addSubTaskToEpic(subTask, epic);
        subTask.setEpicId(epic);
        calculateEpicStatus(epic);
    }

    public void updateTask(Task task) {     // изменение задачи
        listTask.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {     // изменение эпика
        listEpic.put(epic.getId(), epic);
    }

    public void updateSubTask(SubTask subTask) {    // изменение подзадачи
        listSubTask.put(subTask.getId(), subTask);
        int epicId;
        epicId = subTask.epicId;
        calculateEpicStatus(listEpic.get(epicId));
    }

    public void removeTaskById(Task task) {    // удаление задачи по id

        listTask.remove(task.getId());
    }

    public void removeEpicById(Epic epic) {    // удаление эпика по id
        epic.epicSubTask.clear();
        listEpic.remove(epic.getId(), epic);

    }

    public void removeSubTaskById(SubTask subTask) {   // удаление подзадачи по id
        int epicId;
        epicId = subTask.epicId;
        listSubTask.remove(subTask.getId(), subTask);
        calculateEpicStatus(listEpic.get(epicId));

    }

    public void calculateEpicStatus(Epic epic) {    /// отобразить статус эпика
        int allDoneCount = 0;
        int allNewCount = 0;

        for (SubTask sub : epicSubTask) {
            if (sub.getStatus() == StatusOfTask.DONE) {
                allDoneCount++;
            }
            if (sub.getStatus() == StatusOfTask.NEW) {
                allNewCount++;
            }
        }


        if (allNewCount == epicSubTask.size() || epicSubTask.isEmpty()) {
            status = StatusOfTask.NEW;
        } else if (allDoneCount == epicSubTask.size()) {
            status = StatusOfTask.DONE;
        } else {
            status = StatusOfTask.IN_PROGRESS;
        }
    }

}
