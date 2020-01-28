package hu.flowacademy.musicstore.rest;

import hu.flowacademy.musicstore.models.Song;
import hu.flowacademy.musicstore.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SongResource {

    private SongService songService;

    @GetMapping("/songs")
    public List<Song> findAll() {
        return songService.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song findOne(@PathVariable Long id) {
        return songService.findOne(id);
    }

    @PostMapping("/songs")
    public Song newSong(@RequestBody Song song) {
        return songService.saveSong(song);
    }

    @PutMapping("/songs")
    public Song updateSong(@RequestBody Song song) {
        return songService.updateSong(song);
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.ok().build();
    }
}
