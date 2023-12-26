package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Controller.interfaces.PhotoDto;
import ex4.Model.Photo;
import ex4.Repository.PhotoRepository;

@Service
public class PhotoService {
	@Autowired
	PhotoRepository photoRepository;

	public List<PhotoDto> getAllPhoto() {
		return this.photoRepository.findBy();
	}

	public List<PhotoDto> getPhotoOfAlbum(int id) {
		return this.photoRepository.findByAlbum_Id(id);
	}
}
