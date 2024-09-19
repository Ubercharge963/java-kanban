package taskManager.model;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> epicSubTaskList; //создаем список подзадач в эпике
    public Epic(String title, String description, StatusOfTask status ) {
        super(title, description,status);
        epicSubTaskList = new ArrayList<>();
        this.status = status;
    }

    public int getId() {

        return super.id;
    }

    public void addSubTaskToEpic(SubTask subTask, Epic epic) {
        int id = subTask.getId();
        epicSubTaskList.add(id);

    }

    public ArrayList<Integer> getSubTaskInEpic() {

        return epicSubTaskList;
    }

    public void clearSubTaskInEpic() {

        epicSubTaskList.clear();
    }

    public void removeSubTaskById(SubTask subTask) {

        epicSubTaskList.remove(subTask.getId());
    }


    public ArrayList<Integer> getEpicSubTask() {

        return epicSubTaskList;
    }

    public void setEpicSubTask(ArrayList<Integer> epicSubTask) {

        this.epicSubTaskList = epicSubTask;
    }
}
