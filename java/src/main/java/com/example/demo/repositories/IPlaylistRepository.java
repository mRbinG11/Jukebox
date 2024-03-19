package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlist;

public interface IPlaylistRepository {
    Playlist save(Playlist playlist);
    boolean existsById(Long id);
    Optional<Playlist> findById(Long id);
    Optional<Playlist> findByName(String name);
    List<Playlist> findAll();
    void deleteById(Long id);
    void deleteByName(String name);
    long count();
    void setSongIds(Playlist playlist, List<Long> songIds);
}
