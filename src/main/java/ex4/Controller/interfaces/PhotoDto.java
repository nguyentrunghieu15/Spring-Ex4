package ex4.Controller.interfaces;

import org.springframework.beans.factory.annotation.Value;

public interface PhotoDto {
	public int getId();

	public String getTitle();

	public String getUrl();

	public String getThumbnailUrl();

	@Value("#{target.album.id}")
	public int getAlbumId();
}
