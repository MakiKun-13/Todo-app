package sneha.programming.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sneha.programming.todoapp.entity.Todo;
import sneha.programming.todoapp.entity.myUser;
import sneha.programming.todoapp.repository.TodoRepository;
import sneha.programming.todoapp.repository.UserRepository;

@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {

	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		myUser user = new myUser();
		user.setUserName("Sneha");
		user.setPassword("A Complex Password");

		Todo todo = new Todo();
		todo.setContent("Workout");

		user.getTodoList().add(todo);

		userRepository.save(user);

	}
}
