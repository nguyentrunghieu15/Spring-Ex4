package ex4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex4.Model.Post;
import ex4.Service.PostService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;

	@GetMapping("")
	public List<Post> getAll() {
		return this.postService.getAllPost();
	}
	
	@GetMapping("/{id}")
	public Post getPostById(@PathVariable("id") Integer postId) {
	    return postService.getPostById(postId);
	}
}
