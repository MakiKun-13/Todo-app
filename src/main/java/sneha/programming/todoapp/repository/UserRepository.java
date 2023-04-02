package sneha.programming.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sneha.programming.todoapp.entity.myUser;

public interface UserRepository extends JpaRepository<myUser, Long> {
}
