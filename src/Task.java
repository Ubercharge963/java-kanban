
public class Task extends TaskManager {
   protected String title;
    protected String description;
    protected int id;
    StatusOfTask status;
    private  static int taskIdCounter=1;
    public int getId(){
        return id;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.status=StatusOfTask.NEW;
        setId(taskIdCounter++);
    }
    protected int setId(int id){
        this.id=id;
        return id;
    }
    public StatusOfTask getStatus(){
        return status;
    }
    public void setStatus(StatusOfTask status){
        this.status=status;
    }
        @Override
    public String toString(){
            return "Sprint-4{" +
                    "title='" + title + " '" +
            ", description='" + description + " '" +
            ", status=" + status +
                    ", id=" + id +
                    '}';
        }
}
