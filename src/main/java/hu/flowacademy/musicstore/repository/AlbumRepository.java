package hu.flowacademy.musicstore.repository;

import hu.flowacademy.musicstore.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findByTitle(String title);
}
