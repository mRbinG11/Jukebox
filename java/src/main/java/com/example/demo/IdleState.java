package com.example.demo;

import java.util.List;

public class IdleState extends PlayerState {
    public IdleState(Player player) {
        super(player);
    }

    @Override
    public String play() {
        this.player.setCurrentState(new PlayingState(this.player));
        List<Long> songIds = this.player.getSongIds();
        Long currentSongId = songIds.get(0);
        this.player.setCurrentSongId(currentSongId);
        return "Song [id=" + currentSongId + "] is playing!";
    }
}
