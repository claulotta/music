package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.repository.ArtistRepository;
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
public class ArtistService {

    private ArtistRepository artistRepository;

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist findOne(Long id) {

        return artistRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Artist saveAlbum(Artist artist) {
        validateArtist(artist);
        return artistRepository.save(artist);
    }

    public Artist updateAlbum(Artist artist) {
        Artist oldArtist = artistRepository.findById(artist.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));;
        oldArtist.setFirstname(artist.getFirstname());
        oldArtist.setLastname(artist.getLastname());
        return artistRepository.save(oldArtist);
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }

    private void validateArtist(Artist artist) {
        if (StringUtils.isEmpty(artist.getFirstname())) {
            throw new ValidationException("missing firstname");
        }
        if (StringUtils.isEmpty(artist.getLastname())) {
            throw new ValidationException("missing lastname");
        }
    }

}
