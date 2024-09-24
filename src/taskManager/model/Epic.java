package taskManager.model;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Integer> epicSubTaskList; //создаем список подзадач в эпике
    public Epic(String title, String description, StatusOfTask status ) {
        super(title, description,status);
        epicSubTaskList = new ArrayList<>();
        this.status = status;
    }
    public void addSubTaskToEpic(int id) {
        epicSubTaskList.add(id);

    }

    public ArrayList<Integer> getSubTaskInEpic() {

        return epicSubTaskList;
    }

    public void clearSubTaskInEpic() {

        epicSubTaskList.clear();
    }

    public void removeSubTaskById(int subTaskId) {

        epicSubTaskList.remove(Integer.valueOf(subTaskId));
    }

    public void setEpicSubTask(ArrayList<Integer> epicSubTask) {

        this.epicSubTaskList = epicSubTask;
    }
}
