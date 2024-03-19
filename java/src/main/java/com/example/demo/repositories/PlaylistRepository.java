package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {
    private final Map<Long, Playlist> playlistMap;
    private Long autoIncrement = 1L;

    public PlaylistRepository() {
        this.playlistMap = new HashMap<Long, Playlist>();
    }

    @Override
    public Playlist save(Playlist playlist) {
        Playlist p = new Playlist(autoIncrement, playlist.getName(), playlist.getSongIds());
        this.playlistMap.put(autoIncrement++, p);
        return p;
    }

    @Override
    public boolean existsById(Long id) {
        return this.playlistMap.containsKey(id);
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return Optional.ofNullable(this.playlistMap.get(id));
    }

    @Override
    public Optional<Playlist> findByName(String name) {
        return this.playlistMap.values().stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    @Override
    public List<Playlist> findAll() {
        return this.playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.playlistMap.remove(id);
    }

    @Override
    public void deleteByName(String name) {
        Playlist playlist = this.findByName(name).orElseThrow(
                () -> new RuntimeException("Playlist with name: " + name + " not found!"));
        this.deleteById(playlist.getId());
    }

    @Override
    public long count() {
        return this.playlistMap.size();
    }

    @Override
    public void setSongIds(Playlist playlist, List<Long> songIds) {
        playlist.setSongIds(songIds);
        Long id = playlist.getId();
        this.playlistMap.put(id, playlist);
    }
}
