package sneha.programming.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import sneha.programming.todoapp.entity.Todo;
import sneha.programming.todoapp.entity.myUser;
import sneha.programming.todoapp.repository.TodoRepository;
import sneha.programming.todoapp.repository.UserRepository;
import sneha.programming.todoapp.request.AddTodoRequest;
import sneha.programming.todoapp.request.AddUserRequest;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @GetMapping(("{userId}"))
    public myUser getUserBuId(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    /*
    add a new user
     */
    @PostMapping
    public myUser addUser(@RequestBody AddUserRequest userRequest) {
        //@RequestBody is only what we are sending in the Post req. The user only wants to send username and password
        //and no other field of myUser. So, we created a new AddUserRequest bean with only those two objects.
        myUser user = new myUser();
        user.setUserName(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    /*
    find by userid and create a todo
     */
    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {
        myUser user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        todoRepository.save(todo);
        userRepository.save(user); //To add the todo to our user
    }

    /*
    find by todoid and set it completed
     */
    @PostMapping("todos/{todoId}")
    public void setTodoAsCompleted(@PathVariable Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    /*
    deletes a todo of a user
     */
    @DeleteMapping("/{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId, @PathVariable Long userId) {
        myUser user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
    }

    /*
    deletes a user
     */
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        myUser user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }

}
