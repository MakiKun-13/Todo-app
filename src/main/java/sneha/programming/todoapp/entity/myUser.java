package sneha.programming.todoapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //To Define its a database object
public class myUser {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    @OneToMany (cascade = CascadeType.ALL) // Means if we delete user - also deletes todos
    private List<Todo> todoList = new ArrayList<>();

    public myUser(Long id, String userName, String password, List<Todo> todoList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.todoList = todoList;
    }

    public myUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }
}
