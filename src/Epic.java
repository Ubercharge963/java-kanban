import java.util.ArrayList;

public class Epic extends Task {

    public ArrayList<SubTask> epicSubTask; //создаем список подзадач в эпике

    public Epic(String title, String description) {
        super(title, description);
        epicSubTask = new ArrayList<>();
        this. status = StatusOfTask.NEW;
    }
    public int getId(){
        return super.id;
    }

    public void addSubTaskToEpic(SubTask subTask, Epic epic){
        epicSubTask.add(subTask);
        this.status=StatusOfTask.DONE;
        calculateEpicStatus(epic);
    }
    public  ArrayList<SubTask> getSubTaskInEpic() {
        return epicSubTask;
    }
    public void clearSubTaskInEpic() {
        epicSubTask.clear();
    }
    public void removeSubTaskById(SubTask subTask) {
        epicSubTask.remove(subTask.getId());
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
            status =  StatusOfTask.NEW;
        } else if (allDoneCount == epicSubTask.size()) {
            status = StatusOfTask.DONE;
        } else {
            status = StatusOfTask.IN_PROGRESS;
        }
    }
}
