package sneha.programming.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sneha.programming.todoapp.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
