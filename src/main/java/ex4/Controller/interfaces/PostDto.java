package ex4.Controller.interfaces;

import org.springframework.beans.factory.annotation.Value;

public interface PostDto {
	int getId();

	String getTitle();

	String getBody();

	@Value("#{target.user.id}")
	int getUserId();

	// If you need to include comments in the DTO, you can add a method like this:
}