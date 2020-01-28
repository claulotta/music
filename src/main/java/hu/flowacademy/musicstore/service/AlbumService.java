package hu.flowacademy.musicstore.service;

import hu.flowacademy.musicstore.exception.ValidationException;
import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AlbumService {

    private AlbumRepository albumRepository;

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album findOne(String title) {
        return albumRepository.findByTitle(title);
    }

    public Album saveAlbum(Album album) {
        validateAlbum(album);
        return albumRepository.save(album);
    }

    public Album updateAlbum(Album album) {
        Album oldAlbum = albumRepository.findByTitle(album.getTitle());
        oldAlbum.setTitle(album.getTitle());
        oldAlbum.setCount(album.getCount());
        return albumRepository.save(oldAlbum);
    }

    public void delete(Long id) {
        albumRepository.deleteById(id);
    }

    private void validateAlbum(Album album) {
        if (album.getTitle() == null || StringUtils.isEmpty(album.getTitle())) {
            throw new ValidationException("missing title");
        }
        if (album.getCount() < 0) {
            throw new ValidationException("count is too low");
        }
    }
}
