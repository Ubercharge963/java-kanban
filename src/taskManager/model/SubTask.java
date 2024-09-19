package taskManager.model;

public class SubTask extends Epic {
    private int epicId;
    public SubTask(String title, String description, StatusOfTask status) {

        super(title, description,status);
    }

    public int getId() {
        return super.id;
    }
    public void setEpicId(Epic epic){
        epicId=epic.id;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}
