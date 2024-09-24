package taskManager.sevice;

import taskManager.model.Epic;
import taskManager.model.StatusOfTask;
import taskManager.model.SubTask;
import taskManager.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TaskManager {
    private HashMap<Integer,  Task> listTask;
    private HashMap<Integer, Epic> listEpic;
    private HashMap<Integer, SubTask> listSubTask;
    // private   ArrayList<Integer> epicSubTaskList;



    protected int taskIdCounter = 0;

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

    public void clearSubTask() {// удалить все подаздачи
        listSubTask.clear();
        for (Map.Entry<Integer,Epic> epic : listEpic.entrySet()) {
            Epic value=epic.getValue();
            calculateEpicStatus(value);
        }
    }

    public Task getTaskById(int taskId) {    // получение задачи по id

        return listTask.get(taskId);
    }

    public Epic getEpicById(int epicId) {    // получение эпика по id

        return listEpic.get(epicId);
    }

    public SubTask getSubTaskById(int subTaskId) {     // получение подзадачи по id

        return listSubTask.get(subTaskId);
    }

    public void addTask(Task task) {  //+задача
        listTask.put(++taskIdCounter, task);
        task.setId(taskIdCounter);
    }

    public void addEpic(Epic epic) {    //+ эпик

        listEpic.put(++taskIdCounter, epic);
        epic.setId(taskIdCounter);
    }

    public void addSubTask(SubTask subTask, int epicId) {   //+подзадача
        listSubTask.put(++taskIdCounter, subTask);
        subTask.setId(taskIdCounter);
       listEpic.get(epicId).addSubTaskToEpic(taskIdCounter);
       subTask.setEpicId(epicId);
       calculateEpicStatus(listEpic.get(epicId));
    }

    public void updateTask(Task task) {     // изменение задачи

        listTask.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {     // изменение эпика

        listEpic.put(epic.getId(), epic);

    }

    public void updateSubTask(SubTask subTask) {    // изменение подзадачи
        listSubTask.put(subTask.getId(), subTask);
        int epicId = subTask.getEpicId();

        calculateEpicStatus(listEpic.get(epicId));
    }

    public void removeTaskById(int taskId) {    // удаление задачи по id

        listTask.remove(taskId);
    }

    public void removeEpicById(int epicId) {    // удаление эпика по id
        getEpicById(epicId).clearSubTaskInEpic();
        listEpic.remove(epicId);

    }

    public void removeSubTaskById(int subTaskId) {   // удаление подзадачи по id
        int epicId =listSubTask.get(subTaskId).getEpicId();
        listEpic.get(epicId).removeSubTaskById(subTaskId);
        listSubTask.remove(subTaskId);
        calculateEpicStatus(listEpic.get(epicId));

    }

    private void calculateEpicStatus(Epic epic) {    /// отобразить статус эпика
        int allDoneCount = 0;
        int allNewCount = 0;
        if (epic.getSubTaskInEpic() == null) {
            epic.setStatus(StatusOfTask.IN_PROGRESS);

        }
        else{
            ArrayList<Integer> epicSubTasks = epic.getSubTaskInEpic();
            for (int list : epicSubTasks) {
                if (listSubTask.get(list).getStatus() == StatusOfTask.DONE) {
                    allDoneCount++;
                }
                if (listSubTask.get(list).getStatus() == StatusOfTask.NEW) {
                    allNewCount++;
                }
            }


            if (allNewCount ==epicSubTasks.size() || epicSubTasks.isEmpty()) {
                epic.setStatus(StatusOfTask.NEW);
            } else if (allDoneCount == epicSubTasks.size()) {
                epic.setStatus(StatusOfTask.DONE);
            } else {
                epic.setStatus(StatusOfTask.IN_PROGRESS);
            }
        }
    }
}
