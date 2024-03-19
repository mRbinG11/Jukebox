package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song create(String name, String artist, String album, String genre) {
        Song s = new Song(name, artist, album, genre);
        return this.songRepository.save(s);
    }

    public List<Song> getAllSongs() {
        return this.songRepository.findAll();
    }

    public Song getSong(Long id) {
        return this.songRepository.findById(id).orElseThrow(() -> new RuntimeException("Song with id: " + id + " not found!"));
    }
}
