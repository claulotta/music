package hu.flowacademy.musicstore.rest;

import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ArtistResource {

    private ArtistService artistService;

    @GetMapping("/artists")
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @GetMapping("/artists/{name}")
    public Artist findOne(@PathVariable Long id) {
        return artistService.findOne(id);
    }

    @PostMapping("/artists")
    public Artist newArtist(@RequestBody Artist artist) {
        return artistService.saveAlbum(artist);
    }

    @PutMapping("/artists")
    public Artist updateArtist(@RequestBody Artist artist) {
        return artistService.updateAlbum(artist);
    }

    @DeleteMapping("/artists/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artistService.delete(id);
        return ResponseEntity.ok().build();
    }
}
