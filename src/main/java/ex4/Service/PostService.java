package ex4.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Controller.interfaces.PostDto;
import ex4.Model.Post;
import ex4.Repository.PostRepository;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;

	public List<PostDto> getAllPost() {
		return this.postRepository.findBy();
	}

	public Post getPostById(Integer postId) {
		return postRepository.findById(postId).orElse(null);
	}
}
