package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.models.Song;
import hu.flowacademy.musicstore.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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

    public Song saveSong(Song song) {
    if(song.getTitle().equals("")
            || song.getAlbum() == null
            || song.getArtist() == null
            || song.getGenre() == null
            || song.getLength() <=0
            || song.getYear() == null
    )  {throw new ValidationException("Missing data");
    }
    else{
        if(song.getLyrics().equals("")) {
            song.setLyrics(null);
        }
        if(song.getWriterName() == null || song.getWriterName().equals("")){
            song.setWriterName(song.getArtist().getFirstname() + " " + song.getArtist().getLastname());
        }
    songRepository.save(song);}
        return song;
    }
}
