package ex4.Controller.interfaces;

import org.springframework.beans.factory.annotation.Value;

public interface AlbumDto {
	public int getId();

	public String getTitle();

	@Value("#{target.user.id}")
	public int getUserId();
}
