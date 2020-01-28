package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.Song;
import hu.flowacademy.musicstore.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SongService {

    private SongRepository songRepository;

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song findOne(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Song saveSong(Song song) {
       // validateSong(song);
        return songRepository.save(song);
    }

    public Song updateSong(Song song) {
            Song oldSong = songRepository.findById(song.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));;
        oldSong.setLength(song.getLength());
        oldSong.setTitle(song.getTitle());
        oldSong.setGenre(song.getGenre());
        oldSong.setLyrics(song.getLyrics());
        oldSong.setYear(song.getYear());
        oldSong.setWriterName(song.getWriterName());
        return songRepository.save(oldSong);
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    /* private void validateFood(Song song) {
        if (StringUtils.isEmpty(song.getTitle())) {
            throw new ValidationException("missing title");
        }
        if (StringUtils.isEmpty(album.getCount())) {
            throw new ValidationException("missing parts");
        }
    }
     */
}
