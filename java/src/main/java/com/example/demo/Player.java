package com.example.demo;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class Player {
    private final PlaylistService playlistService;

    private PlayerState currentState;
    private List<Long> songIds;
    private Long currentSongId;
    private String playlistName;

    public Player(PlaylistService playlistService) {
        this.playlistService = playlistService;
        this.currentState = new IdleState(this);
    }

    public List<Long> getSongIds() {
        return this.songIds;
    }

    public Long getCurrentSongId() {
        return this.currentSongId;
    }

    public String getPlaylistname() {
        return this.playlistName;
    }

    public void setCurrentState(PlayerState playerState) {
        this.currentState = playerState;
    }

    public void setSongIds(List<Long> songIds) {
        this.songIds = songIds;
    }

    public void setCurrentSongId(Long id) {
        this.currentSongId = id;
    }

    public String onPlay() {
        return this.currentState.play();
    }

    public String onNext() {
        return this.currentState.next();
    }

    public String onPrevious() {
        return this.currentState.back();
    }

    public String onStop() {
        return this.currentState.stop();
    }

    public String loadPlaylist(String name) {
        Playlist p = this.playlistService.getPlaylist(name);
        this.playlistName = name;
        List<Long> songIds = p.getSongIds();
        this.songIds = songIds;
        this.setCurrentState(new IdleState(this));
        return "Playlist " + name + " is loaded!";
    }
}
