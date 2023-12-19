package ex4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
