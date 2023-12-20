package ex4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex4.Model.Photo;
import ex4.Service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/photo")
public class PhotoController {
	@Autowired
	PhotoService photoService;

	@GetMapping("")
	public List<Photo> getAllPhoto() {
		return this.photoService.getAllPhoto();
	}

}
