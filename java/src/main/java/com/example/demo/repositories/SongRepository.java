package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository {
    private final Map<Long, Song> songMap;
    private Long autoIncrement = 1L;

    public SongRepository() {
        this.songMap = new HashMap<Long, Song>();
    }

    @Override
    public Song save(Song song) {
        Song s = new Song(autoIncrement, song.getName(), song.getArtist(), song.getAlbum(), song.getGenre());
        this.songMap.put(autoIncrement++, s);
        return s;
    }

    @Override
    public boolean existsById(Long id) {
        return this.songMap.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.ofNullable(this.songMap.get(id));
    }

    @Override
    public List<Song> findAll() {
        return this.songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public long count() {
        return this.songMap.size();
    }
}
