package ex4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
