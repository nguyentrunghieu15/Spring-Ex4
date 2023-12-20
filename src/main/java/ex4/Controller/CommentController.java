package ex4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex4.Model.Comment;
import ex4.Service.CommentService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentService;

	@GetMapping("")
	public List<Comment> getAllUser() {
		return this.commentService.getAllComment();
	}

}
