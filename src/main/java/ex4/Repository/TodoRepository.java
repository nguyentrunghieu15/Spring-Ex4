package ex4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
