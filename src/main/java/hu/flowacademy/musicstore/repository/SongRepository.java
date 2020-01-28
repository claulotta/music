package hu.flowacademy.musicstore.repository;

import hu.flowacademy.musicstore.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
