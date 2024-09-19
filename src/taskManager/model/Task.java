package taskManager.model;

import taskManager.sevice.TaskManager;

import java.util.Objects;

public class Task extends TaskManager {
    protected String title;
    protected String description;
    protected int id;
    protected StatusOfTask status;


    public int getId() {
        return id;
    }

    public Task(String title, String description, StatusOfTask status) {
        this.title = title;
        this.description = description;
        this.status = status;

    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public StatusOfTask getStatus() {
        return status;
    }

    public void setStatus(StatusOfTask status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                " Название: " + title +" Описание: " + description +
                 " Статус: " + status +"  id= " + id + '\n';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Task that = (Task) object;
        return id == that.id && Objects.equals(getListTask(), that.getListTask()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListTask(),id);
    }
}
