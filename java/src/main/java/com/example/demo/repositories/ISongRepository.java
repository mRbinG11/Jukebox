package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Song;

public interface ISongRepository {
    Song save(Song song);
    boolean existsById(Long id);
    Optional<Song> findById(Long id);
    List<Song> findAll();
    long count();
}
