package taskManager.model;

public class SubTask extends Epic {
    private int epicId;

    public SubTask(String title, String description, StatusOfTask status) {

        super(title, description);
        this.status = status;
    }

    public void setEpicId(Epic epic) {
        epicId = epic.id;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}
