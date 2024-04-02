package taskManager.model;

public class SubTask extends Epic {
    public int epicId;
    public SubTask(String title, String description) {
        super(title, description);
    }

    public int getId() {
        return super.id;
    }
    public void setEpicId(Epic epic){
        epicId=epic.id;
    }
}
