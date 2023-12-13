package ra.md05ss5bttodolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String todolistName;
    private Integer point;
    private Boolean status;

    public Todo() {
    }

    public Todo(Integer id, String todolistName, Integer point, Boolean status) {
        this.id = id;
        this.todolistName = todolistName;
        this.point = point;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodolistName() {
        return todolistName;
    }

    public void setTodolistName(String todolistName) {
        this.todolistName = todolistName;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
