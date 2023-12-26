package ex4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Controller.interfaces.AlbumDto;
import ex4.Model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
	public AlbumDto findById(int id);

	public List<AlbumDto> findBy();

}
