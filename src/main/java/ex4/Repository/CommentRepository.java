package ex4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByPostId(Integer postId);
}

