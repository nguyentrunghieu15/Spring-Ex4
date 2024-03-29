package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Controller.interfaces.CommentDto;
import ex4.Model.Comment;
import ex4.Repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;

	public List<CommentDto> getAllComment() {
		return this.commentRepository.findBy();
	}

	public List<Comment> getCommentsByPostId(Integer postId) {
		return commentRepository.findByPostId(postId);
	}
}
