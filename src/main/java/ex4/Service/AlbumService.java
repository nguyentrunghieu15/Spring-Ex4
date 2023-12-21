package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Model.Album;
import ex4.Repository.AlbumRepository;

@Service
public class AlbumService {
	@Autowired
	AlbumRepository albumRepository;

	public List<Album> getAllAlbum() {
		return this.albumRepository.findAll();
	}
}
