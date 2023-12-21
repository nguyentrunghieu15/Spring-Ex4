package ex4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex4.Model.Album;
import ex4.Service.AlbumService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	AlbumService albumService;

	@GetMapping("")
	public List<Album> getAllAlbum() {
		return this.albumService.getAllAlbum();
	}

}
