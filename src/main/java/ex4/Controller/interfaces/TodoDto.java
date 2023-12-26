package ex4.Controller.interfaces;

import org.springframework.beans.factory.annotation.Value;

public interface TodoDto {
	int getId();

	String getTitle();

	boolean isCompleted();

	@Value("#{target.user.id}")
	int getUserId();
}