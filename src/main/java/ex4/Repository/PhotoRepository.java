package ex4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex4.Model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}
