package com.example.demo;

import java.util.List;

public class PlayingState extends PlayerState {
    public PlayingState(Player player) {
        super(player);
    }

    @Override
    public String play() {
        this.player.setCurrentState(new PausedState(this.player));
        Long currSongId = this.player.getCurrentSongId();
        return "Song [id=" + currSongId + "] is paused!";
    }

    @Override
    public String next() {
        List<Long> songIds = this.player.getSongIds();
        Long currSongId = this.player.getCurrentSongId();
        Integer currSongIndex = songIds.indexOf(currSongId);
        Integer size = songIds.size();
        Integer newIndex = (currSongIndex == size - 1) ? 0 : currSongIndex + 1;
        Long newSongId = songIds.get(newIndex);
        this.player.setCurrentSongId(newSongId);
        return "Song [id=" + newSongId + "] is playing!";
    }

    @Override
    public String back() {
        List<Long> songIds = this.player.getSongIds();
        Long currSongId = this.player.getCurrentSongId();
        Integer currSongIndex = songIds.indexOf(currSongId);
        Integer size = songIds.size();
        Integer newIndex = (currSongIndex == 0) ? size - 1 : currSongIndex - 1;
        Long newSongId = songIds.get(newIndex);
        this.player.setCurrentSongId(newSongId);
        return "Song [id=" + newSongId + "] is playing!";
    }

    @Override
    public String stop() {
        this.player.setCurrentState(new IdleState(this.player));
        Long currSongId = this.player.getCurrentSongId();
        this.player.setCurrentSongId(null);
        return "Song [id=" + currSongId + "] is stopped!";
    }
}
