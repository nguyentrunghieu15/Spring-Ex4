package ex4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
