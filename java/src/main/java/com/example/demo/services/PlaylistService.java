package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService {
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public Playlist create(String name, List<Long> ids) {
        List<Long> songIds = new ArrayList<Long>();
        for (Long id : ids) {
            this.songRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Song with id: " + id + " not found!"));
            songIds.add(id);
        }
        Playlist p = new Playlist(name, songIds);
        return this.playlistRepository.save(p);
    }

    public List<Playlist> getAllPlaylists() {
        return this.playlistRepository.findAll();
    }

    public Playlist getPlaylist(Long id) {
        return this.playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist with id: " + id + " not found!"));
    }

    public Playlist getPlaylist(String name) {
        return this.playlistRepository.findByName(name).orElseThrow(
                () -> new RuntimeException("Playlist with name: " + name + " not found!"));
    }

    public void deletePlaylist(Long id) {
        this.playlistRepository.deleteById(id);
    }

    public void deletePlaylist(String name) {
        this.playlistRepository.deleteByName(name);
    }

    public List<Long> addSong(String name, Long id) {
        Playlist p = this.getPlaylist(name);
        List<Long> songIds = p.getSongIds();
        this.songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song with id: " + id + " not found!"));
        songIds.add(id);
        this.playlistRepository.setSongIds(p, songIds);
        return songIds;
    }

    public List<Long> deleteSong(String name, Long id) {
        Playlist p = this.getPlaylist(name);
        List<Long> songIds = p.getSongIds();
        this.songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song with id: " + id + " not found!"));
        songIds.remove(id);
        this.playlistRepository.setSongIds(p, songIds);
        return songIds;
    }
}
