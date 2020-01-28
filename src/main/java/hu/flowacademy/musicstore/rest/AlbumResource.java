package hu.flowacademy.musicstore.rest;

import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AlbumResource {

    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @GetMapping("/albums/{title}")
    public Album findOne(@PathVariable String title) {
        return albumService.findOne(title);
    }

    @PostMapping("/albums")
    public Album newAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    @PutMapping("/albums")
    public Album updateAlbum(@RequestBody Album album) {
        return albumService.updateAlbum(album);
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        albumService.delete(id);
        return ResponseEntity.ok().build();
    }
}
