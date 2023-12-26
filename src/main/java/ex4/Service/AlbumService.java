package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Controller.interfaces.AlbumDto;
import ex4.Repository.AlbumRepository;

@Service
public class AlbumService {
	@Autowired
	AlbumRepository albumRepository;

	public List<AlbumDto> getAllAlbum() {
		return this.albumRepository.findBy();
	}

	public AlbumDto getAlbumById(int id) {
		return this.albumRepository.findById(id);
	}
}
