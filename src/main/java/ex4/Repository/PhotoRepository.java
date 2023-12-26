package ex4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Controller.interfaces.PhotoDto;
import ex4.Model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	public List<PhotoDto> findByAlbum_Id(int id);

	public List<PhotoDto> findBy();
}
