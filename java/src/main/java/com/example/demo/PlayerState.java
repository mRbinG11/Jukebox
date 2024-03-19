package com.example.demo;

public class PlayerState {
    protected Player player;

    public PlayerState(Player player) {
        this.player = player;
    }

    public String play() {
        return "Sorry Music Cannot be played";
    }

    public String next() {
        return "Sorry next song Cannot be played";
    }

    public String back() {
        return "Sorry previous song Cannot be played";
    }

    public String stop() {
        return "Sorry Music Cannot be played as Music is already stopped";
    }
}
