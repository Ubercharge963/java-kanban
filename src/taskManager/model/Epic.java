package taskManager.model;

import taskManager.sevice.StatusOfTask;

import java.util.ArrayList;

public class Epic extends Task {

    public ArrayList<SubTask> epicSubTask; //создаем список подзадач в эпике
    public Epic(String title, String description) {
        super(title, description);
        epicSubTask = new ArrayList<>();
        this.status = StatusOfTask.NEW;
    }

    public int getId() {
        return super.id;
    }

    public void addSubTaskToEpic(SubTask subTask, Epic epic) {
        epicSubTask.add(subTask);
        calculateEpicStatus(epic);
    }

    public ArrayList<SubTask> getSubTaskInEpic() {
        return epicSubTask;
    }

    public void clearSubTaskInEpic() {
        epicSubTask.clear();
    }

    public void removeSubTaskById(SubTask subTask) {
        epicSubTask.remove(subTask.getId());
    }


}
