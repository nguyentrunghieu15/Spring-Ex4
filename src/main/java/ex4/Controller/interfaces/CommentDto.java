package ex4.Controller.interfaces;

import org.springframework.beans.factory.annotation.Value;

public interface CommentDto {
	int getId();

	String getName();

	String getEmail();

	String getBody();

	@Value("#{target.post.id}")
	int getPostId();
}