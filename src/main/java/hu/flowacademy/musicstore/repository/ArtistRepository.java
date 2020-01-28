package hu.flowacademy.musicstore.repository;

import hu.flowacademy.musicstore.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {


}
