package ex4.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Model.Post;
import ex4.Repository.PostRepository;


@Service
public class PostService {
	@Autowired
	PostRepository postRepository;

	public List<Post> getAllPost() {
		return this.postRepository.findAll();
	}
	
    public Post getPostById(Integer postId) {
    	return postRepository.findById(postId).orElse(null);
    }
}
