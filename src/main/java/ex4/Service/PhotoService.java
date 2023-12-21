package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Model.Photo;
import ex4.Repository.PhotoRepository;

@Service
public class PhotoService {
	@Autowired
	PhotoRepository photoRepository;

	public List<Photo> getAllPhoto() {
		return this.photoRepository.findAll();
	}
}
